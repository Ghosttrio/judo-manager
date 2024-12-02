package com.ghosttrio.judomanager.auth.application.port.in.impl;

import com.ghosttrio.judomanager.auth.application.port.in.LogoutUseCase;
import com.ghosttrio.judomanager.auth.application.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogoutUseCaseImpl implements LogoutUseCase {

    private final LogoutService logoutService;

    @Override
    public void execute(String accessToken) {
        logoutService.logout(accessToken);
    }
}
