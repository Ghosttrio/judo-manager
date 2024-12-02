package com.ghosttrio.judomanager.auth.application.port.out;

import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoTokenResponse;
import com.ghosttrio.judomanager.auth.adapter.port.out.feign.model.response.KakaoUserInfoResponse;
import org.springframework.web.bind.annotation.RequestParam;

public interface KakaoClientPort {
    KakaoUserInfoResponse getKakaoUserInfo(String code);
    KakaoTokenResponse getKakaoToken(String grant_type, String client_id, String redirect_uri, String code);
}
