package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.application.port.in.UpdateUserDanUseCase;
import com.ghosttrio.judomanager.user.application.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserDanUseCaseImpl implements UpdateUserDanUseCase {

    private final UpdateUserService updateUserService;

    @Override
    public void execute(Long grade) {
//        updateUserService.updateDan(grade);
    }
}
