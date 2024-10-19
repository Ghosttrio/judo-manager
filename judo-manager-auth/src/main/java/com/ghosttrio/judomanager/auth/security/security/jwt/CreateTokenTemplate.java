//package com.ghosttrio.judomanager.auth.security.security.jwt;
//
//import com.ghosttrio.judomanager.auth.security.security.jwt.response.TokenResponse;
//import com.judomanager.infrastructure.redis.RedisService;
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//public abstract class CreateTokenTemplate implements JwtGenerator {
//
//    protected final RedisService redisService;
//    protected final JwtResolver jwtResolver;
//
//    protected abstract String createAccessToken(Long id, String email);
//    protected abstract String createRefreshToken();
//
//    @Override
//    public final TokenResponse createToken(Long id, String email) {
//        deleteExistTokenValues(email);
//        String accessToken = createAccessToken(id, email);
//        String refreshToken = createRefreshToken();
//        createTokenValuesWithTimeout(email, refreshToken);
//        return new TokenResponse(accessToken, refreshToken);
//    }
//
//    protected void deleteExistTokenValues(String email) {
//        if (redisService.getValues(email).isPresent()) {
//            redisService.deleteValues(email);
//        }
//    }
//
//    protected void createTokenValuesWithTimeout(String email, String refreshToken) {
//        long tokenExpirationTime = jwtResolver.getTokenExpirationTime(refreshToken);
//        redisService.setValuesWithTimeout(email, refreshToken, tokenExpirationTime);
//    }
//
//}
