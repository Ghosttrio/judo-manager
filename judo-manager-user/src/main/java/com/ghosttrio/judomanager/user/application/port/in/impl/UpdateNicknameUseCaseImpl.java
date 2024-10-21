package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.application.port.in.UpdateNicknameUseCase;
import com.ghosttrio.judomanager.user.application.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateNicknameUseCaseImpl implements UpdateNicknameUseCase {

    private final UpdateUserService updateUserService;

    @Override
    public void execute(Long userId, String nickname) {
        updateUserService.updateNickname(userId, nickname);
    }
}
