package com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;

public class UserRequest {

    public record Create(
            String email,
            String nickname,
            UserRole role
    ) {
    }

    public record Nickname(String nickname) {
    }

    public record Dojo(String dojoCode) {
    }

    public record Dan(Long grade) {
    }
}
