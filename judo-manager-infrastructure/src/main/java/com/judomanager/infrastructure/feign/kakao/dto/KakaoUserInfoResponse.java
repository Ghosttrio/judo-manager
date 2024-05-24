package com.judomanager.infrastructure.feign.kakao.dto;


public record KakaoUserInfoResponse(
        Long id,
        String connected_at,
        KakaoAccount kakao_account
) {

}
