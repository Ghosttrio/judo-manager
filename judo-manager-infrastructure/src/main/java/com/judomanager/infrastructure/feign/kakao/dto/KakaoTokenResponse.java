package com.judomanager.infrastructure.feign.kakao.dto;


public record KakaoTokenResponse(
        String access_token,
        String refresh_token,
        String token_type,
        int expires_in,
        String scope,
        int refresh_token_expires_in
) {
}