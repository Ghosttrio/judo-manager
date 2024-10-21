package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.application.port.in.LoadUserUseCase;
import com.ghosttrio.judomanager.user.application.service.LoadUserService;
import com.ghosttrio.judomanager.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadUserUseCaseImpl implements LoadUserUseCase {

    private final LoadUserService loadUserService;

    @Override
    public User execute(Long id) {
        return loadUserService.findById(id);
    }
}
