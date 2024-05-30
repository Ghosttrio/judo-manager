package com.judomanager.domain.security.jwt.response;

public record SigninResponse(
        Long userId,
        String accessToken,
        String refreshToken
) {
}
