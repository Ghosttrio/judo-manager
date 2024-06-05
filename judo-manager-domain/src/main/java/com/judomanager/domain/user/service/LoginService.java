package com.judomanager.domain.user.service;

import com.judomanager.domain.security.jwt.response.AccessTokenResponse;
import com.judomanager.domain.security.jwt.response.SigninResponse;

public interface LoginService {

    SigninResponse login(String kakaoCode);

    AccessTokenResponse refresh(String email, String requestAccessToken);
}
