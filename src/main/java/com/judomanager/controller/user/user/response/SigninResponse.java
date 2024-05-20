package com.judomanager.controller.user.user.response;

public record SigninResponse(
        Long memberId,
        String accessToken,
        String refreshToken
) {
}
