package com.ghosttrio.judomanager.user.domain;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserEntity;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserState;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private String nickname;
    private String email;
    private UserRole role;
    private UserState state;
    private LocalDateTime lastLoginDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long dojoId;

    public static UserEntity init(String email) {
        return new UserEntity(
                null,
                "이름",
                UserRole.MEMBER,
                null,
                email,
                LocalDateTime.now(),
                UserState.ACTIVATED);
    }

    public void withDrawUser() {
        this.state = UserState.DELETED;
        this.nickname = "탈퇴유저";
        this.email = null;
        this.dojoId = null;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDojo(Long dojoId) {
        this.dojoId = dojoId;
    }

    public void updateLoginDate() {
        this.lastLoginDate = LocalDateTime.now();
    }
}
