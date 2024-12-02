package com.ghosttrio.judomanager.auth.application.service;

import com.ghosttrio.judomanager.auth.common.properties.JwtTokenProperty;
import com.ghosttrio.judomanager.auth.security.test.JwtProvider;
import com.ghosttrio.judomanager.auth.security.test.TokenResponse;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


// TODO 수정
@Service
@RequiredArgsConstructor
@Slf4j
public class RefreshService {

    private final RedisService redisService;
    private final JwtTokenProperty jwtTokenProperty;
    private final JwtProvider jwtProvider;


    public TokenResponse refresh(String email, String accessToken) {
        validateRefreshToken(email, accessToken);
        return jwtProvider.createToken("1L", email,null);
    }

    public void validateRefreshToken(String email, String accessToken) {
        try {
            String values = redisService.getValues(email);
//            Jwts.parser()
//                    .parse(accessToken)
//                    .parseClaimsJws(accessToken)
//                    .getBody();
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT Token");
        } catch (SignatureException e) {
            log.error("Invalid JWT signature.");
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token.");
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token.");
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty.");
        } catch (NullPointerException e){
            log.error("JWT Token is empty.");
        }
    }
}
