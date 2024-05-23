package com.judomanager.api.security.jwt;

import com.judomanager.api.security.CustomUserDetailsService;
import com.judomanager.api.security.jwt.response.TokenResponse;
import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.judomanager.infrastructure.redis.RedisService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static com.judomanager.common.util.JudoMangerStatic.ACCESS_TOKEN_VALID_TIME;
import static com.judomanager.common.util.JudoMangerStatic.REFRESH_TOKEN_VALID_TIME;


@Component
@Slf4j
public class JwtGenerator {

    private final Key signingKey;
    private final RedisService redisService;
    private final CustomUserDetailsService customUserDetailsService;

    public JwtGenerator(@Value("${jwt.secret}") String secretKey,
                        RedisService redisService,
                        CustomUserDetailsService customUserDetailsService) {
        this.redisService = redisService;
        this.customUserDetailsService = customUserDetailsService;
        this.signingKey = generateSigningKey(secretKey);
    }

    private Key generateSigningKey(String secretKey){
        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }


    public TokenResponse createToken(Long id, String email){
        if(redisService.getValues(email).isPresent()){
            redisService.deleteValues(email);
        }
        long now = Timestamp.valueOf(LocalDateTime.now()).getTime();
        Date accessTokenExpiration = new Date(now + ACCESS_TOKEN_VALID_TIME);
        Date refreshTokenExpiration = new Date(now + REFRESH_TOKEN_VALID_TIME);

        String accessToken = Jwts.builder()
                .setSubject("access-token")
                .setExpiration(accessTokenExpiration)
                .claim("id", id)
                .claim("email", email)
                .signWith(signingKey, SignatureAlgorithm.HS512)
                .compact();
        String refreshToken = Jwts.builder()
                .setSubject("refresh-token")
                .setExpiration(refreshTokenExpiration)
                .signWith(signingKey, SignatureAlgorithm.HS512)
                .compact();
        redisService.setValuesWithTimeout(email, refreshToken, getTokenExpirationTime(refreshToken));

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }


    public Authentication getAuthentication(String accessToken) {
        Claims claims = getClaims(accessToken);
        UserDetails user = customUserDetailsService.loadUserByUsername(claims.get("id").toString());
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }


    public Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) { // Access Token
            return e.getClaims();
        }
    }

    public long getTokenExpirationTime(String token) {
        return getClaims(token).getExpiration().getTime();
    }

    public boolean validateToken(String accessToken) {
        try {
            if (redisService.getValues(accessToken).isPresent()){
                return false;
            }
            Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(accessToken);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT Token");
            throw new JMException(ErrorCode.EXPIRED_TOKEN);
        } catch (SignatureException e) {
            log.error("Invalid JWT signature.");
            throw new JMException(ErrorCode.INVALID_SIGNATURE);
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token.");
            throw new JMException(ErrorCode.INVALID_TOKEN);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token.");
            throw new JMException(ErrorCode.UNSUPPORTED_TOKEN);
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty.");
            throw new JMException(ErrorCode.EMPTY_TOKEN);
        } catch (NullPointerException e){
            log.error("JWT Token is empty.");
            throw new JMException(ErrorCode.EMPTY_TOKEN);
        }
    }

    public boolean validateRefreshToken(String email) {
        try {
            String refreshToken = redisService.getValues(email)
                    .orElseThrow(() -> new JMException(ErrorCode.EXPIRED_REFRESH_TOKEN));
            Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(refreshToken);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT Token");
            throw new JMException(ErrorCode.EXPIRED_REFRESH_TOKEN);
        } catch (SignatureException e) {
            log.error("Invalid JWT signature.");
            throw new JMException(ErrorCode.INVALID_SIGNATURE);
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token.");
            throw new JMException(ErrorCode.INVALID_TOKEN);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token.");
            throw new JMException(ErrorCode.UNSUPPORTED_TOKEN);
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty.");
            throw new JMException(ErrorCode.EMPTY_TOKEN);
        } catch (NullPointerException e){
            log.error("JWT Token is empty.");
            throw new JMException(ErrorCode.EMPTY_TOKEN);
        }
    }

}