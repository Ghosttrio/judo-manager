//package com.ghosttrio.judomanager.auth.security.config;
//
//import com.ghosttrio.judomanager.auth.security.CustomUserDetailsService;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class AuthenticationLoader {
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    public Authentication getAuthentication(String accessToken) {
//        Key key = jwtKeyGenerator.generateSigningKey();
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(key)
//                    .build()
//                    .parseClaimsJws(accessToken)
//                    .getBody();
//        } catch (ExpiredJwtException e) { // Access Token
//            e.getClaims();
//        }
//
//
//        UserDetails user = customUserDetailsService.loadUserByUsername(claims.get("id").toString());
//        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//    }
//
//    public Claims getClaims(String token) {
//
//    }
//
//}
