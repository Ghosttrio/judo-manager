package com.judomanager.api.security.jwt.response;


public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}