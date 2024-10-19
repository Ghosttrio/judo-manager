//package com.ghosttrio.judomanager.user.user.user.service;
//
//import com.judomanager.common.exception.ErrorCode;
//import com.judomanager.common.exception.JMException;
//import com.judomanager.common.properties.KakaoProperties;
//import com.judomanager.domain.security.jwt.JwtGenerator;
//import com.judomanager.domain.security.jwt.JwtResolver;
//import com.judomanager.domain.security.jwt.JwtValidator;
//import com.judomanager.domain.security.jwt.response.AccessTokenResponse;
//import com.judomanager.domain.security.jwt.response.SigninResponse;
//import com.judomanager.domain.security.jwt.response.TokenResponse;
//import com.ghosttrio.judomanager.user.user.user.domain.User;
//import com.judomanager.infrastructure.feign.kakao.client.KakaoTokenClient;
//import com.judomanager.infrastructure.feign.kakao.client.KakaoUserInfoClient;
//import com.judomanager.infrastructure.feign.kakao.dto.KakaoTokenResponse;
//import com.judomanager.infrastructure.feign.kakao.dto.KakaoUserInfoResponse;
//import com.judomanager.infrastructure.redis.RedisService;
//import io.jsonwebtoken.Claims;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//
//@Slf4j
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class LoginService {
//
//    private final KakaoUserInfoClient kakaoUserInfoClient;
//    private final KakaoTokenClient kakaoTokenClient;
//    private final KakaoProperties kakaoProperties;
//    private final CreateUserService createUserService;
//    private final JwtGenerator jwtGenerator;
//    private final UpdateUserService updateUserService;
//    private final RedisService redisService;
//    private final JwtValidator jwtValidator;
//    private final JwtResolver jwtResolver;
//
//
//
//    @Transactional
//    public SigninResponse login(String kakaoCode){
//        String email = getUserEmailByKakaoCode(kakaoCode);
//        User user = createUserService.signup(email);
//        TokenResponse token = jwtGenerator.createToken(user.getId(), user.getEmail());
//        updateUserService.lastLogin(user.getId());
//        return new SigninResponse(user.getId(), token.accessToken(), token.refreshToken());
//    }
//
//
//    private String getUserEmailByKakaoCode(String kakaoCode){
//
//        KakaoTokenResponse response = kakaoTokenClient.authorize(
//                kakaoProperties.getClient_id(),
//                kakaoProperties.getClient_secret(),
//                kakaoProperties.getGrant_type(),
//                kakaoProperties.getRedirect_uri(),
//                kakaoCode);
//
//        String kakaoAccessToken = response.access_token();
//
//        KakaoUserInfoResponse userInfo = kakaoUserInfoClient.getUserInfo("Bearer " + kakaoAccessToken);
//
//        return userInfo.kakao_account().email();
//    }
//
//
//    public AccessTokenResponse refresh(String email, String requestAccessToken){
//        // refresh 토큰 accessToken으로 redis에서 가져오기
//        Optional<String> refreshToken = redisService.getValues(email);
//
//        // refresh 토큰 validate 리프레시 토큰까지 만료되면 페이지 이동 요청
//        if(refreshToken.isPresent() && jwtValidator.validateRefreshToken(email)){
//
//            // 액세스 토큰 추출
//            String accessToken = jwtResolver.resolveToken(requestAccessToken);
//
//            redisService.deleteValues(email);
//            Claims claims = jwtResolver.getClaims(accessToken);
//            Long userId = Long.parseLong(claims.get("id").toString());
//
//            // 액세스, 리프레시 토큰 생성
//            TokenResponse token = jwtGenerator.createToken(
//                    userId,
//                    email);
//
//            // 레디스에 새로 발급한 리프레스 토큰 저장
//            redisService.setValuesWithTimeout(
//                    email,
//                    token.refreshToken(),
//                    jwtResolver.getTokenExpirationTime(token.refreshToken()));
//
//            // 액세스 토큰 리턴
//            return new AccessTokenResponse(token.accessToken());
//        }else {
//            throw new JMException(ErrorCode.EXPIRED_REFRESH_TOKEN);
//        }
//    }
//
//
//}
