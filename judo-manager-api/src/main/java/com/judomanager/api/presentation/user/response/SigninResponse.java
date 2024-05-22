package com.judomanager.api.presentation.user.response;

public record SigninResponse(
        Long memberId,
        String accessToken,
        String refreshToken
) {
}
