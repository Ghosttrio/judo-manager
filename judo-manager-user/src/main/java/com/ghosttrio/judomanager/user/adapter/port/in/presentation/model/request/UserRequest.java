package com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request;

import com.ghosttrio.judomanager.user.domain.Belt;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.ghosttrio.judomanager.user.domain.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

    public record Create(
            @Email(message = "이메일은 필수입니다.")
            String email,
            @NotEmpty(message = "닉네임은 필수입니다.")
            String nickname,
            UserRole role,
            String location,
            Double latitude,
            Double longitude
    ) {
        public CreateUserServiceRequest toService() {
            return new CreateUserServiceRequest(email, nickname, role, location, latitude, longitude);
        }

        public record CreateUserServiceRequest(
                String email,
                String nickname,
                UserRole role,
                String location,
                Double latitude,
                Double longitude
        ) {
        }
    }

    public record Nickname(
            @NotEmpty String nickname
    ) {
    }

    public record Dojo(
            @NotNull String dojoCode
    ) {
    }

    public record Dan(
            @NotNull Grade grade,
            @NotNull Belt belt
    ) {
    }
}
