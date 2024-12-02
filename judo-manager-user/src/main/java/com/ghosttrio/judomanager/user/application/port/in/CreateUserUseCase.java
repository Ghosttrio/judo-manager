package com.ghosttrio.judomanager.user.application.port.in;


import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;

public interface CreateUserUseCase {
    void execute(String email, String nickname, UserRole role);
}
