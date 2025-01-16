package com.ghosttrio.judomanager.user.application.port.in.impl;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.response.UserResponse.LoadUserResponse;
import com.ghosttrio.judomanager.user.application.port.in.LoadUserUseCase;
import com.ghosttrio.judomanager.user.application.service.LoadUserService;
import com.ghosttrio.judomanager.user.domain.UserDomain;
import com.ghosttrio.judomanager.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadUserUseCaseImpl implements LoadUserUseCase {

    private final LoadUserService loadUserService;
    private final UserMapper userMapper;

    @Override
    public LoadUserResponse execute(Long id) {
        UserDomain userDomain = loadUserService.findById(id);
        return userMapper.toLoadUserResponse(userDomain);
    }
}
