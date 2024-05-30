package com.judomanager.domain.security.jwt;

import com.judomanager.domain.security.jwt.response.TokenResponse;

public interface JwtGenerator {
    TokenResponse createToken(Long id, String email);
}
