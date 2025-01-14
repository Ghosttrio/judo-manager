package com.ghosttrio.judomanager.user.application.port.in;

import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.response.UserResponse.LoadUserResponse;

public interface LoadUserUseCase {
    LoadUserResponse execute(Long id);
}
