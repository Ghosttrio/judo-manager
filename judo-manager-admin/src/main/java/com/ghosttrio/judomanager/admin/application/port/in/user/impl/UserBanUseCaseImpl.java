package com.ghosttrio.judomanager.admin.application.port.in.user.impl;

import com.ghosttrio.judomanager.admin.application.port.in.user.UserBanUseCase;
import com.ghosttrio.judomanager.admin.application.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserBanUseCaseImpl implements UserBanUseCase {

    private final UpdateUserService updateUserService;

    @Override
    public void execute(Long userId) {
        updateUserService.ban(userId);
    }
}
