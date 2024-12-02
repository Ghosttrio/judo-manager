package com.ghosttrio.judomanager.auth.adapter.port.out.feign;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoTokenResponse;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoUserInfoResponse;
import com.ghosttrio.judomanager.auth.application.port.out.KakaoClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KakaoClientAdapter implements KakaoClientPort {

    private final KakaoTokenClient kakaoTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;

    @Override
    public KakaoUserInfoResponse getKakaoUserInfo(String code) {
        return kakaoUserInfoClient.getKakaoUserInfo(code);
    }

    @Override
    public KakaoTokenResponse getKakaoToken(String grant_type, String client_id, String redirect_uri, String code) {
        return kakaoTokenClient.getKakaoToken(grant_type, client_id, redirect_uri, code);
    }
}
