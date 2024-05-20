package com.judomanager.controller.user.user.kakao;


public record KakaoTokenRequest(
        String client_id,
        String client_secret,
        String grant_type,
        String redirect_uri,
        String code
) {
}
