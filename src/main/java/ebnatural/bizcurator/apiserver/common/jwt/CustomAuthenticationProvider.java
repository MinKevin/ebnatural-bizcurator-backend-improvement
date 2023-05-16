package ebnatural.bizcurator.apiserver.common.jwt;

import ebnatural.bizcurator.apiserver.dto.MemberPrincipalDetails;
import ebnatural.bizcurator.apiserver.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
/**
 * 전달받은 사용자의 아이디와 비밀번호를 기반으로 비즈니스 로직을 처리하여 사용자의 ‘인증’에 대해서 검증을 수행하는 클래스
 * CustomAuthenticationFilter로 부터 생성한 토큰을 통하여 ‘UserDetailsService’를 통해 데이터베이스 내에서 정보를 조회
 */
@Slf4j
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Resource
    private MemberService memberService;

    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("CustomAuthenticationProvider");
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        // 'AuthenticationFilter'에서 생성된 토큰으로부터 아이디와 비밀번호를 조회
        String username = token.getName();
        String password = (String) token.getCredentials();

        //Spring Security - UserDetailsService를 통해 DB에서 아이디로 사용자 조회
         MemberPrincipalDetails member = (MemberPrincipalDetails) memberService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, member.getPassword())){
            throw new BadCredentialsException((member.getUsername() + "Invalid Password"));
        }

        return new UsernamePasswordAuthenticationToken(member, password, member.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
