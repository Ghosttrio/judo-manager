package com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.response;

import com.ghosttrio.judomanager.user.domain.Belt;
import com.ghosttrio.judomanager.user.domain.Grade;
import com.ghosttrio.judomanager.user.domain.UserRole;
import com.ghosttrio.judomanager.user.domain.UserState;

import java.time.LocalDateTime;

public class UserResponse {

    public record LoadUserResponse(
            Long id,
            String nickname,
            UserRole role,
            String email,
            UserState state,
            LocalDateTime lastLoginDate,
            Long dojoId,
            Belt belt,
            Grade grade,
            String location,
            Double latitude,
            Double longitude
    ) {
    }
}
