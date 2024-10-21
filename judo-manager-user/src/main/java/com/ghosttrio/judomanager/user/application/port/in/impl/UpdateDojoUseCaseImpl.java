package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.application.port.in.UpdateDojoUseCase;
import com.ghosttrio.judomanager.user.application.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateDojoUseCaseImpl implements UpdateDojoUseCase {

    private final UpdateUserService updateUserService;

    @Override
    public void execute(Long userId, String dojoCode) {
        updateUserService.update(userId, dojoCode);
    }
}
