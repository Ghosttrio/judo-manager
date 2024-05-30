package com.judomanager.domain.security.jwt.response;


public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}