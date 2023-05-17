package ebnatural.bizcurator.apiserver.common.config.filter;

import ebnatural.bizcurator.apiserver.common.jwt.JwtProvider;
import ebnatural.bizcurator.apiserver.domain.Member;
import ebnatural.bizcurator.apiserver.repository.MemberRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * JWT를 이용한 인증처리
 */
@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;
    private final MemberRepository memberRepository;

    /**
     * 페이지에 접근 시도시 "Authorization"헤더에 있는 access token을 검사한다.
     * access token이 만료됐으면 throw ExpiredJwtException -> FilterExceptionHandler에서 error code response를 보낸다.
     * access token이 만료되지 않았으면 SecurityContextHolder에 Authentication을 저장한다.
     * @return
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String accessToken = jwtProvider.resolveToken(request);
        if(null != accessToken) {
            try {
                Claims claims = jwtProvider.verifyToken(accessToken);
                Member member = Optional.of(memberRepository.findByUsername(claims.getSubject())).orElseThrow(() ->
                        new BadCredentialsException("Access Token의 잘못된 계정정보입니다."));

                Authentication auth = jwtProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (ExpiredJwtException e) {
                throw e;
            } catch (Exception e){
                throw e;
            }
        }
        filterChain.doFilter(request, response);
    }

}