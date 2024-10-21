//package com.ghosttrio.judomanager.auth.security.security.jwt;
//
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class JwtKeyGenerator {
//
//    private final JwtProperties jwtProperties;
//
//    public Key generateSigningKey(){
//        byte[] secretKeyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
//        return Keys.hmacShaKeyFor(secretKeyBytes);
//    }
//
//}
