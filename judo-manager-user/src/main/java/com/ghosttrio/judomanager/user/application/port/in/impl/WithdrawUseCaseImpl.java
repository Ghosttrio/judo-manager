package com.ghosttrio.judomanager.user.application.port.in.impl;


import com.ghosttrio.judomanager.user.application.port.in.WithdrawUseCase;
import com.ghosttrio.judomanager.user.application.service.WithdrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WithdrawUseCaseImpl implements WithdrawUseCase {

    private final WithdrawService withdrawService;

    @Override
    public void execute(Long userId) {
        withdrawService.withdraw(userId);
    }
}
