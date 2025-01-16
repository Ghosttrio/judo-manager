package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.application.port.in.PromotionUserUseCase;
import com.ghosttrio.judomanager.user.application.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromotionUserUseCaseImpl implements PromotionUserUseCase {

    private final UpdateUserService updateUserService;

    @Override
    public void execute(Long userId) {
        updateUserService.promotionGrade(userId);
    }
}
