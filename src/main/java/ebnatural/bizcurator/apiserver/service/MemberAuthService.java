package ebnatural.bizcurator.apiserver.service;

import ebnatural.bizcurator.apiserver.common.config.aop.LoginLog;
import ebnatural.bizcurator.apiserver.common.exception.custom.BadRequestException;
import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.common.exception.custom.InvalidUsernamePasswordException;
import ebnatural.bizcurator.apiserver.common.jwt.JwtProvider;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.dto.TokenDto;
import ebnatural.bizcurator.apiserver.dto.MemberDto;
import ebnatural.bizcurator.apiserver.dto.request.LoginRequest;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberAuthService {
    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    /**
     * 로그인 처리 + 엑세스, 리프레시 토큰 생성 + db저장
     * @param loginDto
     * @return
     * @throws Exception
     */
    @LoginLog
    public MemberDto login(LoginRequest loginDto) {

        Member member = Optional.ofNullable(memberRepository.findByUsername(loginDto.getUsername()))
                .orElseThrow(() ->
                        new InvalidUsernamePasswordException(ErrorCode.USERNAME_OR_PASSWORD_WRONG));

        if (!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
            throw new InvalidUsernamePasswordException(ErrorCode.USERNAME_OR_PASSWORD_WRONG);
        }

        String newRefreshToken = createRefreshToken(member);
        TokenDto tokenDto = TokenDto.builder()
                .accessToken(jwtProvider.createAccessToken(member.getId(), member.getUsername(), member.getMemberRole()))
                .refreshToken(newRefreshToken)
                .build();

        return MemberDto.from(member, tokenDto);
    }

    /**
     * 프론트 단에서는 Local Storage에 저장된 access, refresh token 폐기한다.
     * user_account 테이블의 refresh token 컬럼값을 없애준다.
     * @param accessToken 회원정보를 꺼내올 access token
     */
    public boolean logout(String accessToken) {
        String userName = null;
        try {
            Claims claims = jwtProvider.verifyToken(accessToken);
            userName = claims.getSubject();
        } catch (ExpiredJwtException e) {
            userName = e.getClaims().getSubject();
        } catch (Exception e){
            throw e;
        }

        Member member = Optional.ofNullable(memberRepository.findByUsername(userName))
                .orElseThrow(() ->
                        new BadCredentialsException("access token의 잘못된 계정정보입니다."));

        member.setRefreshToken("");
        // refresh token을 빈 문자열로 업데이트 한다. (지워준다)
        memberRepository.updateRefreshToken("", member.getId());
        return true;
    }



    /**
     * refresh 토큰 생성 + userAccount에 저장 + member db 테이블에 저장
     * @param member
     * @return
     */
    public String createRefreshToken(Member member) {
        if (member == null) {
            return null;
        }

        String newRefreshToken = jwtProvider.createRefreshToken(member);
        if (newRefreshToken == null) {
            return null;
        }

        member.setRefreshToken(newRefreshToken);
        memberRepository.updateRefreshToken(newRefreshToken, member.getId());
        return newRefreshToken;
    }

    /**
     * access 토큰 재발급
     * @param accessToken 엑세스 토큰
     * @return
     * @throws Exception
     */
    public TokenDto refreshToken(String accessToken) throws Exception {
        String userName = null;

        try{
            userName = jwtProvider.getUsernameByToken(accessToken);
        } catch (ExpiredJwtException ex){
            // access 토큰이 만료됐으면
            userName = ex.getClaims().getSubject();
        }

        Member member = Optional.ofNullable(memberRepository.findByUsername(userName))
                .orElseThrow(() ->
                        new BadRequestException(ErrorCode.USER_NOT_FOUND));
        String currentRefreshToken = member.getRefreshToken();
        try {
            Claims claims = jwtProvider.verifyToken(currentRefreshToken);
        } catch (ExpiredJwtException | IllegalArgumentException e) {
            // refresh token이 만료됐거나 null이면 재로그인을 해야함
            throw new ExpiredJwtException(null, null, null);
        } catch (Exception e){
            throw e;
        }

        return TokenDto.builder()
                .accessToken(jwtProvider.createAccessToken(member.getId(), member.getUsername(), member.getMemberRole()))
                .refreshToken(currentRefreshToken)
                .build();
    }
}
