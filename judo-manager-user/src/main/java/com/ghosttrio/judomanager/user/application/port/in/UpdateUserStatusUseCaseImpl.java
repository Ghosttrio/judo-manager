package com.ghosttrio.judomanager.user.application.port.in;

import com.ghosttrio.judomanager.user.application.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserStatusUseCaseImpl implements UpdateUserStatusUseCase {

    private final UpdateUserService updateUserService;

    @Override
    public void execute(Long userId) {
        updateUserService.updateStatus(userId);
    }
}
