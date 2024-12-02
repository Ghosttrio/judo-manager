//package com.ghosttrio.judomanager.auth.security.security.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.security.Key;
//
//@Component
//@RequiredArgsConstructor
//public class JwtResolver {
//
//    private final JwtKeyGenerator jwtKeyGenerator;
//

//
//    public Claims getClaims(String token) {
//        Key key = jwtKeyGenerator.generateSigningKey();
//        try {
//            return Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (ExpiredJwtException e) { // Access Token
//            return e.getClaims();
//        }
//    }
//
//    public long getTokenExpirationTime(String token) {
//        return getClaims(token).getExpiration().getTime();
//    }
//
//}