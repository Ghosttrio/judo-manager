package com.judomanager.api.controller.user.user.response;

public record SigninResponse(
        Long memberId,
        String accessToken,
        String refreshToken
) {
}
