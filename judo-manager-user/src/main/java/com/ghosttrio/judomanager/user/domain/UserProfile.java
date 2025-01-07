package com.ghosttrio.judomanager.user.domain;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfile {
    private String nickname;
    private String email;
    private UserRole role;
    private UserAddress userAddress;

    public static UserProfile createUserProfile(String nickname, String email, UserRole role, UserAddress userAddress) {
        return new UserProfile(nickname, email, role, userAddress);
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void removeUserProfile() {
        this.nickname = "탈퇴유저";
        this.email = "";
    }
}
