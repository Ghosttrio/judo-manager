package com.ghosttrio.judomanager.admin.application.port.in.user.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import com.ghosttrio.judomanager.admin.application.port.in.user.LoadUserUseCase;
import com.ghosttrio.judomanager.admin.application.service.LoadUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadUserUseCaseImpl implements LoadUserUseCase {

    private final LoadUserService loadUserService;

    @Override
    public List<User> execute() {
        return loadUserService.findAll();
    }
}
