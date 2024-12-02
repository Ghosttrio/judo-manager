package com.ghosttrio.judomanager.auth.security.test;

import com.ghosttrio.judomanager.auth.common.properties.JwtTokenProperty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtTokenProperty jwtTokenProperty;

    public TokenResponse createToken(String id, String email, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(id);
        claims.put("ROLES", roles);
        claims.put("email", email);
        LocalDateTime now = LocalDateTime.now();

        long currentTime = Timestamp.valueOf(now).getTime();
        long expireTime = currentTime + 30 * 60 * 1000L;
        String accessToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(expireTime))
                .signWith(SignatureAlgorithm.HS256, jwtTokenProperty.getSecret())
                .compact();

        String refreshToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setExpiration(new Date(currentTime + 30 * 60 * 100000L))
                .signWith(SignatureAlgorithm.HS256, jwtTokenProperty.getSecret())
                .compact();
        return new TokenResponse("Bearer", "Bearer " + accessToken, refreshToken, LocalDateTime.now());
    }
}
