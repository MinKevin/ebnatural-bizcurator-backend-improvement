package ebnatural.bizcurator.apiserver.common.jwt;

import ebnatural.bizcurator.apiserver.domain.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import org.springframework.data.util.Pair;

import java.security.Key;
import java.util.Date;

public class JwtUtils {
    /**
     * 토큰에서 username 찾기
     *
     * @param token 토큰
     * @return username
     */
    public static String getUsername(String token) {
        // jwtToken에서 username을 찾습니다.
        return Jwts.parserBuilder()
                .setSigningKeyResolver(SigningKeyResolver.instance)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // username
    }

    public static Long getMemberIdByToken(String token) {
        return Long.valueOf(
                Jwts.parserBuilder()
                        .setSigningKeyResolver(SigningKeyResolver.instance)
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
                        .getIssuer()
        );
    }

    /**
     * user로 토큰 생성
     * HEADER : alg, kid
     * PAYLOAD : sub(username), iss(Id), iat(발행시간), exp(만료시간)
     * SIGNATURE : JwtKey.getRandomKey로 구한 Secret Key로 HS512 해시
     *
     * @param member 유저
     * @return jwt token
     */
    public static String createToken(Member member) {
        Claims claims = Jwts.claims().setSubject(member.getUsername())
                .setIssuer(String.valueOf(member.getId()));

        Date now = new Date(); // 현재 시간
        Pair<String, Key> key = JwtKey.getRandomKey();
        // JWT Token 생성
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + JwtProperties.EXPIRATION_TIME)) // 토큰 만료 시간 설정
                .setHeaderParam(JwsHeader.KEY_ID, key.getFirst()) // kid
                .signWith(key.getSecond()) // signature
                .compact();
    }
}
