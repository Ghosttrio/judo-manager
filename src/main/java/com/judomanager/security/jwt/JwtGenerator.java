//package com.judomanager.security.jwt;
//
//import com.judomanager.common.exception.ErrorCode;
//import com.judomanager.security.CustomUserDetailsService;
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.stream.Collectors;
//
//@Component
//@Slf4j
//public class JwtGenerator {
//
//    private final Key signingKey;
//    private static final long ACCESS_TOKEN_VALID_TIME = 30 * 60 * 1000L; // 30분
//    private static final long REFRESH_TOKEN_VALID_TIME = 7 * 24 * 60 * 60 * 1000L; // 7일
//    private final RedisService redisService;
//    private final CustomUserDetailsService customUserDetailsService;
//
//    public JwtGenerator(@Value("${jwt.secret}") String secretKey,
//                        CustomUserDetailsService userDetailsService,
//                        RedisService redisService, CustomUserDetailsService customUserDetailsService) {
//        this.redisService = redisService;
//        this.customUserDetailsService = customUserDetailsService;
//        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
//        this.signingKey = Keys.hmacShaKeyFor(secretKeyBytes);
//    }
//
//
//    public TokenResponse createToken(Long id, String email, String role){
//        long now = Timestamp.valueOf(LocalDateTime.now()).getTime();
//        Date accessTokenExpiration = new Date(now + ACCESS_TOKEN_VALID_TIME);
//        Date refreshTokenExpiration = new Date(now + REFRESH_TOKEN_VALID_TIME);
//
//        String accessToken = Jwts.builder()
//                .setSubject("access-token")
//                .setExpiration(accessTokenExpiration)
//                .claim("auth", role)
//                .claim("id", id)
//                .claim("email", email)
//                .signWith(signingKey, SignatureAlgorithm.HS512)
//                .compact();
//        String refreshToken = Jwts.builder()
//                .setSubject("refresh-token")
//                .setExpiration(refreshTokenExpiration)
//                .signWith(signingKey, SignatureAlgorithm.HS512)
//                .compact();
//
//        return TokenResponse.builder()
//                .accessToken(accessToken)
//                .refreshToken(refreshToken)
//                .build();
//    }
//
////    public Authentication getAuthentication(String accessToken){
////        String id = getClaims(accessToken).get("id").toString();
////        UserDetails userDetails = userDetailsService.loadUserByUsername(id);
////        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
////    }
//
//    public Authentication getAuthentication(String accessToken) {
//        Claims claims = getClaims(accessToken);
//        UserDetails user = customUserDetailsService.loadUserByUsername(claims.get("id").toString());
//
////        Collection<? extends GrantedAuthority> authorities =
////                Arrays.stream(claims.get("auth").toString().split(","))
////                        .map(SimpleGrantedAuthority::new)
////                        .collect(Collectors.toList());
//
////        CustomUserDetails user =
////                new CustomUserDetails(Long.valueOf(claims.get("id").toString()), claims.get("email").toString(), authorities);
//
//        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//    }
//
//
//    public Claims getClaims(String token) {
//        try {
//            return Jwts.parserBuilder()
//                    .setSigningKey(signingKey)
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (ExpiredJwtException e) { // Access Token
//            return e.getClaims();
//        }
//    }
//
//    public String getRole(Authentication authentication){
//        authentication.getAuthorities().stream().forEach(System.out::println);
//        return authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//    }
//    public long getTokenExpirationTime(String token) {
//        return getClaims(token).getExpiration().getTime();
//    }
//
//    public boolean validateToken(String accessToken) {
//        try {
//            if (redisService.getValues(accessToken).isPresent()){
//                return false;
//            }
//            Jwts.parserBuilder()
//                    .setSigningKey(signingKey)
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
//}