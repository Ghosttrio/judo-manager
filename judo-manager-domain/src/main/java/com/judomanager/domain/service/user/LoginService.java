//package com.judomanager.domain.service.user;
//
//import com.judomanager.common.common.properties.KakaoProperties;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
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
//    private final JwtResolver jwtResolver;
//    private final UpdateUserService updateUserService;
//
//    public SigninResponse login(String kakaoCode){
//        User user = getUserByKakaoCode(kakaoCode);
//        TokenResponse token = createTokenAndSetRedis(user);
//        updateUserService.lastLogin(user.getId());
//        return new SigninResponse(user.getId(), token.getAccessToken(), token.getRefreshToken());
//    }
//
//    private TokenResponse createTokenAndSetRedis(User user){
//        return jwtGenerator.createToken(user.getId(), user.getEmail(), user.getRole().toString());
//    }
//
//    private User getUserByKakaoCode(String kakaoCode){
//        KakaoTokenResponse response = kakaoTokenClient.authorize(new KakaoTokenRequest(
//                kakaoProperties.getClient_id(),
//                kakaoProperties.getClient_secret(),
//                kakaoProperties.getGrant_type(),
//                kakaoProperties.getRedirect_uri(),
//                kakaoCode
//        ));
//
//        String kakaoAccessToken = response.getAccess_token();
//
//        KakaoUserInfoResponse userInfo = kakaoUserInfoClient.getUserInfo(kakaoAccessToken);
//
//        String email = userInfo.getKakao_account().getEmail();
//
//        return createUserService.signup(email);
//    }
//
//
//
//    public String refresh(String email, String requestAccessToken){
//        jwtGenerator.validRefreshToken(email);
//
//        String accessToken = jwtResolver.resolveToken(requestAccessToken);
//
//        Authentication authentication = jwtGenerator.getAuthentication(accessToken);
//
//        return jwtGenerator.createToken(100L , email, jwtGenerator.getRole(authentication)).getAccessToken();
//    }
//
//
//
//}
