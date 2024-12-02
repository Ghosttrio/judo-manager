package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.application.port.in.LoadUserUseCase;
import com.ghosttrio.judomanager.user.application.service.LoadUserService;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadUserUseCaseImpl implements LoadUserUseCase {

    private final LoadUserService loadUserService;

    @Override
    public UserDomain execute(Long id) {
        return loadUserService.findById(id);
    }
}
