package com.ghosttrio.judomanager.auth.application.service;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoTokenResponse;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoUserInfoResponse;
import com.ghosttrio.judomanager.auth.application.port.out.KakaoClientPort;
import com.ghosttrio.judomanager.auth.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.auth.common.exception.ErrorCode;
import com.ghosttrio.judomanager.auth.common.exception.JMException;
import com.ghosttrio.judomanager.auth.common.properties.KakaoProperties;
import com.ghosttrio.judomanager.auth.security.test.JwtProvider;
import com.ghosttrio.judomanager.auth.security.test.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtProvider jwtProvider;
    private final KakaoClientPort kakaoClientPort;
    private final KakaoProperties kakaoProperties;
    private final RedisService redisService;
    private final UserClientPort userClientPort;

    public TokenResponse login(String kakaoCode) {
        KakaoTokenResponse kakaoToken = kakaoClientPort.getKakaoToken(
                kakaoProperties.getGrant_type(),
                kakaoProperties.getClient_id(),
                kakaoProperties.getRedirect_uri(),
                kakaoCode
        );
        KakaoUserInfoResponse kakaoUserInfo = kakaoClientPort.getKakaoUserInfo(kakaoToken.access_token());
        userClientPort.loadUserByEmail(kakaoUserInfo.getKakaoAccount().getEmail())
                .ifPresent(user -> {
                    throw new JMException(ErrorCode.USER_NOT_FOUND);
                });
        TokenResponse token = jwtProvider.createToken(kakaoUserInfo.getId(), kakaoUserInfo.getKakaoAccount().getEmail(), null);
        redisService.setValuesWithTimeout(kakaoUserInfo.getKakaoAccount().getEmail(), token.refreshToken(), 8640000);
        return token;
    }
}