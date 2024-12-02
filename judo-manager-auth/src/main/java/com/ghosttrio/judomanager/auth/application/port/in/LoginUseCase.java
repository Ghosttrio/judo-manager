package com.ghosttrio.judomanager.auth.application.port.in;

import com.ghosttrio.judomanager.auth.security.test.TokenResponse;

public interface LoginUseCase {
    TokenResponse execute(String kakaoCode);
}
