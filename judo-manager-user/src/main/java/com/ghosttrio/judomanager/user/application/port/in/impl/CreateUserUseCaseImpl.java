package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import com.ghosttrio.judomanager.user.application.port.in.CreateUserUseCase;
import com.ghosttrio.judomanager.user.application.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateUserService createUserService;

    @Override
    public void execute(String email, String nickname, UserRole role) {
        createUserService.signup(email, nickname, role);
    }
}
