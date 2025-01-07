package com.ghosttrio.judomanager.user.domain;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDomain {

    private Long id;
    private UserProfile userProfile;
    private UserState state;
    private LocalDateTime lastLoginDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long dojoId;
    private Belt belt;

    public static UserDomain generateUserDomain(UserProfile userProfile) {
        return new UserDomain(
                null,
                userProfile,
                UserState.ACTIVATED,
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                0L,
                Belt.WHITE); // 0L은 미등록 도장 코드
    }

    @Builder
    public UserDomain(UserProfile userProfile, UserState state, Long dojoId) {
        this.userProfile = userProfile;
        this.state = state;
        this.dojoId = dojoId;
    }

    public UserDomain withDrawUser() {
        this.state = UserState.DELETED;
        this.dojoId = 0L;
        this.userProfile.removeUserProfile();
        return this;
    }

    public void changeUserNickname(String nickname) {
        this.userProfile.updateNickname(nickname);
    }

    public Belt promotion(Belt belt) {
        Belt[] belts = Belt.values();
        int currentIndex = belt.ordinal(); // 현재 벨트의 인덱스를 구함

        // 벨트의 마지막이면 승급 불가 (최상위 벨트)
        if (currentIndex == belts.length - 1) {
            return belt; // 이미 최고 벨트인 경우, 현재 벨트를 그대로 반환
        }

        // 현재 벨트보다 상위 벨트를 반환
        return belts[currentIndex + 1];
    }

    public void setDojo(Long dojoId) {
        this.dojoId = dojoId;
    }

    public void updateLoginDate() {
        this.lastLoginDate = LocalDateTime.now();
    }

    public void updateStatus() {
        this.state = UserState.DEACTIVATED;
    }

    public void updateDan() {

    }
}
