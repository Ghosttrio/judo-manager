package com.ghosttrio.judomanager.auth.application.service;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.request.CreateUserRequest;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoTokenResponse;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoUserInfoResponse;
import com.ghosttrio.judomanager.auth.application.port.out.KakaoClientPort;
import com.ghosttrio.judomanager.auth.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.auth.common.exception.JMException;
import com.ghosttrio.judomanager.auth.common.properties.KakaoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.ghosttrio.judomanager.auth.common.exception.ErrorCode.NICKNAME_DUPLICATE;
import static com.ghosttrio.judomanager.auth.common.exception.ErrorCode.USER_DUPLICATE;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserClientPort userClientPort;
    private final KakaoClientPort kakaoClientPort;
    private final KakaoProperties kakaoProperties;

    @Transactional
    public void signup(String kakaoCode) {
        KakaoUserInfoResponse kakaoUserInfo = createKakaoUserInfo(kakaoCode);
        checkDuplicateUser(kakaoUserInfo.getKakaoAccount().getEmail());
        checkDuplicateNickname(kakaoUserInfo.getProperties().getNickname());
        CreateUserRequest request = createRequest(kakaoUserInfo);
        userClientPort.signup(request);
    }

    private KakaoUserInfoResponse createKakaoUserInfo(String kakaoCode) {
        KakaoTokenResponse kakaoToken = kakaoClientPort.getKakaoToken(
                kakaoProperties.getGrant_type(),
                kakaoProperties.getClient_id(),
                kakaoProperties.getRedirect_uri(),
                kakaoCode);
        return kakaoClientPort.getKakaoUserInfo(kakaoToken.access_token());
    }

    private void checkDuplicateUser(String email) {
        userClientPort.loadUserByEmail(email).ifPresent(user -> {throw new JMException(USER_DUPLICATE);});
    }

    private void checkDuplicateNickname(String nickname) {
        userClientPort.loadUserByNickname(nickname)
                .ifPresent(user -> {throw new JMException(NICKNAME_DUPLICATE);});
    }

    private CreateUserRequest createRequest(KakaoUserInfoResponse kakaoUserInfo) {
        return CreateUserRequest.builder()
                .id(kakaoUserInfo.getId())
                .email(kakaoUserInfo.getKakaoAccount().getEmail())
                .name(kakaoUserInfo.getKakaoAccount().getName())
                .profileImageUrl(kakaoUserInfo.getKakaoAccount().getProfile().getProfileImageUrl())
                .nickname(kakaoUserInfo.getProperties().getNickname())
                .phoneNumber(kakaoUserInfo.getKakaoAccount().getPhoneNumber())
                .build();
    }



}
