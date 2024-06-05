package com.judomanager.domain.user.service;

import com.judomanager.common.exception.ErrorCode;
import com.judomanager.common.exception.JMException;
import com.judomanager.common.properties.KakaoProperties;
import com.judomanager.domain.security.jwt.JwtGenerator;
import com.judomanager.domain.security.jwt.JwtResolver;
import com.judomanager.domain.security.jwt.JwtValidator;
import com.judomanager.domain.security.jwt.response.AccessTokenResponse;
import com.judomanager.domain.security.jwt.response.SigninResponse;
import com.judomanager.domain.security.jwt.response.TokenResponse;
import com.judomanager.domain.user.domain.User;
import com.judomanager.infrastructure.feign.kakao.client.KakaoTokenClient;
import com.judomanager.infrastructure.feign.kakao.client.KakaoUserInfoClient;
import com.judomanager.infrastructure.feign.kakao.dto.KakaoTokenResponse;
import com.judomanager.infrastructure.feign.kakao.dto.KakaoUserInfoResponse;
import com.judomanager.infrastructure.redis.RedisService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * 협력(collaboration) : 객체들이 애플리케이션의 기능을 구현하기 위해 수행하는 상호작용
 * 책임(responsibility) : 객체가 협력에 참여하기 위해 수행하는 로직
 * 책임은 하는 것 + 아는 것
     * 하는 것
         * 객체를 생성하거나 계산을 수행하는 등의 스스로 하는 것
         * 다른 객체의 행동을 시작시키는 것
         * 다른 객체의 활동을 제어하고 조절하는 것
     * 아는 것
         * 사적인 정보에 관해 아는 것
         * 관련된 객체에 관해 아는 것
         * 자신이 유도하거나 계산할 수 있는 것에 관해 아는 것
 *
 * 역할(role) : 객체들이 협력 안에서 수행하는 책임들이 모여 객체가 수행
 *  객체의 목적은 협력 안에서 객체가 맡게 되는 책임의 집합으로 표시된다.
 *
 * 역할이 중요한 이유는 역할을 통해 유연하고 재사용 가능한 협력을 얻을 수 있기 때문이다.
 */


/**
 * 생각해보자
 * 1. LoginService의 책임은 무엇인가?
 *  - SigninResponse를 생성해서 돌려주는 것
 *  - User 객체를 만들도록 요청하는 것
 *  - TokenResponse 객체를 만들도록 요청하는 것
 *
 * 2. LoginService의 역할은 무엇인가?
 *  - 유연하고 재사용 가능한 협력을 얻을 수 있기 때문이라는데 재사용 가능한 협력을 얻으려면 LoginService를 어떻게 해야하지?
 *  - LoginController가 LoginService에게 보내는 메시지는 뭐지? -> 로그인을 실행해서 결과를 알려줘
 *  - 행동이 상태를 결정한다.
 *  - 행동 -> 로그인을 실행
 *  - 상태 -> 로그인 성공, 로그인 실패
 *
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final KakaoUserInfoClient kakaoUserInfoClient;
    private final KakaoTokenClient kakaoTokenClient;
    private final KakaoProperties kakaoProperties;
    private final CreateUserService createUserService;
    private final JwtGenerator jwtGenerator;
    private final UpdateUserService updateUserService;
    private final RedisService redisService;
    private final JwtValidator jwtValidator;
    private final JwtResolver jwtResolver;

    @Override
    public SigninResponse login(String kakaoCode){
        return createSigninResponse(kakaoCode);
    }

    private SigninResponse createSigninResponse(String kakaoCode){
        String email = getUserEmailByKakaoCode(kakaoCode);
        User user = createUserService.signup(email);
        TokenResponse token = jwtGenerator.createToken(user.getId(), user.getEmail());
        updateUserService.lastLogin(user.getId());
        return new SigninResponse(user.getId(), token.accessToken(), token.refreshToken());
    }


    private String getUserEmailByKakaoCode(String kakaoCode){
        KakaoTokenResponse response = kakaoTokenClient.authorize(
                kakaoProperties.getClient_id(),
                kakaoProperties.getClient_secret(),
                kakaoProperties.getGrant_type(),
                kakaoProperties.getRedirect_uri(),
                kakaoCode);
        String kakaoAccessToken = response.access_token();
        KakaoUserInfoResponse userInfo = kakaoUserInfoClient.getUserInfo("Bearer " + kakaoAccessToken);
        return userInfo.kakao_account().email();
    }

    @Override
    public AccessTokenResponse refresh(String email, String requestAccessToken){
        return tokenRefresh(email, requestAccessToken);
    }

    private AccessTokenResponse tokenRefresh(String email, String requestAccessToken){
        validToken(email);
        return refreshTokenGenerator(email, requestAccessToken);
    }

    private void validToken(String email){
        jwtValidator.validateRefreshToken(email);
    }

    private AccessTokenResponse refreshTokenGenerator(String email, String requestAccessToken){
        Long userId = getUserIdInToken(email, requestAccessToken);
        TokenResponse token = jwtGenerator.createToken(userId, email);
        setExpireTime(email, token.refreshToken());
        return new AccessTokenResponse(token.accessToken());
    }

    private Long getUserIdInToken(String email, String requestAccessToken){
        String accessToken = jwtResolver.resolveToken(requestAccessToken);
        redisService.deleteValues(email);
        Claims claims = jwtResolver.getClaims(accessToken);
        return Long.parseLong(claims.get("id").toString());
    }

    private void setExpireTime(String email, String refreshToken){
        long tokenExpirationTime = jwtResolver.getTokenExpirationTime(refreshToken);
        redisService.setValuesWithTimeout(email, refreshToken, tokenExpirationTime);
    }


}
