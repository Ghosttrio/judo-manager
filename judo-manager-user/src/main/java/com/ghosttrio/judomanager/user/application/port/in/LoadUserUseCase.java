package com.ghosttrio.judomanager.user.application.port.in;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.domain.User;

public interface LoadUserUseCase {
    User execute(Long id);
}
