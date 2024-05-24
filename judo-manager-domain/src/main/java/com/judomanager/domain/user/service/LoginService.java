package com.judomanager.domain.user.service;

import com.judomanager.common.properties.KakaoProperties;
import com.judomanager.domain.user.domain.User;
import com.judomanager.infrastructure.feign.kakao.client.KakaoTokenClient;
import com.judomanager.infrastructure.feign.kakao.client.KakaoUserInfoClient;
import com.judomanager.infrastructure.feign.kakao.dto.KakaoTokenRequest;
import com.judomanager.infrastructure.feign.kakao.dto.KakaoTokenResponse;
import com.judomanager.infrastructure.feign.kakao.dto.KakaoUserInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final KakaoUserInfoClient kakaoUserInfoClient;
    private final KakaoTokenClient kakaoTokenClient;
    private final KakaoProperties kakaoProperties;
    private final CreateUserService createUserService;

    @Transactional
    public User login(String kakaoCode){
        String email = getUserEmailByKakaoCode(kakaoCode);
        return createUserService.signup(email);
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


}
