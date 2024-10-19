//package com.ghosttrio.judomanager.auth.security.security.jwt;
//
//import com.judomanager.common.exception.ErrorCode;
//import com.judomanager.common.exception.JMException;
//import com.judomanager.infrastructure.redis.RedisService;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.UnsupportedJwtException;
//import io.jsonwebtoken.security.SignatureException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class JwtValidator {
//
//    private final RedisService redisService;
//    private final JwtKeyGenerator jwtKeyGenerator;
//
//
//    public boolean validateToken(String accessToken) {
//        try {
//            if (redisService.getValues(accessToken).isPresent()){
//                return false;
//            }
//            Key key = jwtKeyGenerator.generateSigningKey();
//            Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(accessToken);
//            return true;
//        } catch (ExpiredJwtException e) {
//            log.error("Expired JWT Token");
//            throw new JMException(ErrorCode.EXPIRED_TOKEN);
//        } catch (SignatureException e) {
//            log.error("Invalid JWT signature.");
//            throw new JMException(ErrorCode.INVALID_SIGNATURE);
//        } catch (MalformedJwtException e) {
//            log.error("Invalid JWT token.");
//            throw new JMException(ErrorCode.INVALID_TOKEN);
//        } catch (UnsupportedJwtException e) {
//            log.error("Unsupported JWT token.");
//            throw new JMException(ErrorCode.UNSUPPORTED_TOKEN);
//        } catch (IllegalArgumentException e) {
//            log.error("JWT claims string is empty.");
//            throw new JMException(ErrorCode.EMPTY_TOKEN);
//        } catch (NullPointerException e){
//            log.error("JWT Token is empty.");
//            throw new JMException(ErrorCode.EMPTY_TOKEN);
//        }
//    }
//
//    public boolean validateRefreshToken(String email) {
//        try {
//            String refreshToken = redisService.getValues(email)
//                    .orElseThrow(() -> new JMException(ErrorCode.EXPIRED_REFRESH_TOKEN));
//            Key key = jwtKeyGenerator.generateSigningKey();
//            Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(refreshToken);
//            return true;
//        } catch (ExpiredJwtException e) {
//            log.error("Expired JWT Token");
//            throw new JMException(ErrorCode.EXPIRED_REFRESH_TOKEN);
//        } catch (SignatureException e) {
//            log.error("Invalid JWT signature.");
//            throw new JMException(ErrorCode.INVALID_SIGNATURE);
//        } catch (MalformedJwtException e) {
//            log.error("Invalid JWT token.");
//            throw new JMException(ErrorCode.INVALID_TOKEN);
//        } catch (UnsupportedJwtException e) {
//            log.error("Unsupported JWT token.");
//            throw new JMException(ErrorCode.UNSUPPORTED_TOKEN);
//        } catch (IllegalArgumentException e) {
//            log.error("JWT claims string is empty.");
//            throw new JMException(ErrorCode.EMPTY_TOKEN);
//        } catch (NullPointerException e){
//            log.error("JWT Token is empty.");
//            throw new JMException(ErrorCode.EMPTY_TOKEN);
//        }
//    }
//
//}
