package com.ghosttrio.judomanager.auth.security.test;


import java.time.LocalDateTime;

public record TokenResponse(
        String grantType,
        String accessToken,
        String refreshToken,
        LocalDateTime accessTokenExpireDate
) {
}
