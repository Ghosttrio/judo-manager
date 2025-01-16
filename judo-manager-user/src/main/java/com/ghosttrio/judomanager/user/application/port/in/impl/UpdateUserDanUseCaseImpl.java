package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.application.port.in.UpdateUserDanUseCase;
import com.ghosttrio.judomanager.user.application.service.UpdateUserService;
import com.ghosttrio.judomanager.user.domain.Belt;
import com.ghosttrio.judomanager.user.domain.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserDanUseCaseImpl implements UpdateUserDanUseCase {

    private final UpdateUserService updateUserService;

    @Override
    public void execute(Long userId, Grade grade, Belt belt) {
        updateUserService.updateGrade(userId, grade, belt);
    }
}
