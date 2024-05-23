package com.judomanager.api.security.jwt.response;

public record SigninResponse(
        Long userId,
        String accessToken,
        String refreshToken
) {
}
