//package com.ghosttrio.judomanager.auth.security.security.jwt;
//
//import com.judomanager.infrastructure.redis.RedisService;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.security.Key;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import static com.judomanager.common.util.JudoMangerStatic.ACCESS_TOKEN_VALID_TIME;
//import static com.judomanager.common.util.JudoMangerStatic.REFRESH_TOKEN_VALID_TIME;
//
//public class CreateToken extends CreateTokenTemplate {
//
//    private final JwtKeyGenerator jwtKeyGenerator;
//
//    public CreateToken(RedisService redisService, JwtResolver jwtResolver, JwtKeyGenerator jwtKeyGenerator) {
//        super(redisService, jwtResolver);
//        this.jwtKeyGenerator = jwtKeyGenerator;
//    }
//
//    @Override
//    protected String createAccessToken(Long id, String email) {
//        long now = Timestamp.valueOf(LocalDateTime.now()).getTime();
//        Date accessTokenExpiration = new Date(now + JudoMangerStatic.ACCESS_TOKEN_VALID_TIME);
//        Key key = jwtKeyGenerator.generateSigningKey();
//        return Jwts.builder()
//                .setSubject("access-token")
//                .setExpiration(accessTokenExpiration)
//                .claim("id", id)
//                .claim("email", email)
//                .signWith(key, SignatureAlgorithm.HS512)
//                .compact();
//    }
//
//    @Override
//    protected String createRefreshToken() {
//        long now = Timestamp.valueOf(LocalDateTime.now()).getTime();
//        Date refreshTokenExpiration = new Date(now + JudoMangerStatic.REFRESH_TOKEN_VALID_TIME);
//        Key key = jwtKeyGenerator.generateSigningKey();
//        return Jwts.builder()
//                .setSubject("refresh-token")
//                .setExpiration(refreshTokenExpiration)
//                .signWith(key, SignatureAlgorithm.HS512)
//                .compact();
//    }
//}
