package ebnatural.bizcurator.apiserver.common.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ebnatural.bizcurator.apiserver.common.exception.custom.ErrorCode;
import ebnatural.bizcurator.apiserver.dto.response.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class FilterExceptionHandler extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            //토큰의 유효기간 만료
            setErrorResponse(response, ErrorCode.JWT_EXPIRED);
        } catch (JwtException | IllegalArgumentException e) {
            // 변조된 토큰
            setErrorResponse(response, ErrorCode.JWT_WRONG);
        } catch (InsufficientAuthenticationException | AuthenticationException e) {
            // 인증 오류
            setErrorResponse(response, ErrorCode.AUTHENTICATION_WRONG);
        } catch (AccessDeniedException e) {
            // 권한이 없는 요청을 함
            setErrorResponse(response, ErrorCode.AUTHORIZATION_WRONG);
        } catch (BadCredentialsException e) {
            // 잘못된 계정정보
            setErrorResponse(response, ErrorCode.BAD_CREDENTIALS);
        } catch (Exception e) {
            // 그 외 오류
            setErrorResponse(response, ErrorCode.SERVER_ERROR);
        }
    }

    private void setErrorResponse(
            HttpServletResponse response,
            ErrorCode errorCode
    ) throws IOException {

        response.setStatus(errorCode.getHttpStatusCode().value());
        response.setCharacterEncoding("utf-8");
        response.setContentType("raw/json; charset=UTF-8");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FieldError fieldError = new FieldError("MemberRequest", "", null, false, new String[]{errorCode.getHttpStatusCode().getReasonPhrase()}, null, errorCode.getMessage());

        response.getWriter().write(gson.toJson(ErrorResponse.ValidationError.of(fieldError)));
    }

}