package com.ghosttrio.judomanager.auth.application.port.in.impl;

import com.ghosttrio.judomanager.auth.application.port.in.LoginUseCase;
import com.ghosttrio.judomanager.auth.application.service.LoginService;
import com.ghosttrio.judomanager.auth.security.test.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {

    private final LoginService loginService;

    @Override
    public TokenResponse execute(String kakaoCode) {
        return loginService.login(kakaoCode);
    }
}
