package com.ghosttrio.judomanager.auth.adapter.port.in.model.response;

public record LoginResponse(
        String grantType,
        String accessToken,
        String refreshToken,
        String accessTokenExpireDate
) {
}
