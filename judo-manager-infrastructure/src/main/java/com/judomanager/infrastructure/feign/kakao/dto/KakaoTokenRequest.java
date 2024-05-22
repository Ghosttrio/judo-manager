package com.judomanager.infrastructure.feign.kakao.dto;


public record KakaoTokenRequest(
        String client_id,
        String client_secret,
        String grant_type,
        String redirect_uri,
        String code
) {
}
