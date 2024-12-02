package com.ghosttrio.judomanager.auth.application.port.in.impl;

import com.ghosttrio.judomanager.auth.application.port.in.SignupUseCase;
import com.ghosttrio.judomanager.auth.application.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignupUseCaseImpl implements SignupUseCase {

    private final SignupService signupService;

    @Override
    public void execute(String kakaoCode) {
        signupService.signup(kakaoCode);
    }
}
