package com.judomanager.infrastructure.feign.kakao.dto;


public record KakaoAccount(
        Boolean has_email,
        Boolean email_needs_agreement,
        Boolean is_email_valid,
        Boolean is_email_verified,
        String email
) {
}
