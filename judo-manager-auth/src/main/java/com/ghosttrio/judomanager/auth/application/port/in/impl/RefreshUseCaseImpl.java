package com.ghosttrio.judomanager.auth.application.port.in.impl;

import com.ghosttrio.judomanager.auth.application.port.in.RefreshUseCase;
import com.ghosttrio.judomanager.auth.application.service.RefreshService;
import com.ghosttrio.judomanager.auth.security.test.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshUseCaseImpl implements RefreshUseCase {

    private final RefreshService refreshService;

    @Override
    public TokenResponse execute(String email, String accessToken) {
        return refreshService.refresh(email, accessToken);
    }
}
