package com.ghosttrio.judomanager.user.domain;

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
    private Grade grade;

    public static UserDomain generateUserDomain(UserProfile userProfile) {
        return new UserDomain(
                null,
                userProfile,
                UserState.ACTIVATED,
                LocalDateTime.now(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                0L,
                Belt.WHITE,
                Grade.KYU1); // 0L은 미등록 도장 코드
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

    public void setDojo(Long dojoId) {
        this.dojoId = dojoId;
    }

    public void updateLoginDate() {
        this.lastLoginDate = LocalDateTime.now();
    }

    public void userDeactivate() {
        this.state = UserState.DEACTIVATED;
    }

    public PromotionResult promotionGrade() {
        Grade promotionGrade = this.grade.promotion();
        Belt promtionBelt = this.belt.promotion(promotionGrade);
        return new PromotionResult(promotionGrade, promtionBelt);
    }

    public record PromotionResult(
            Grade grade,
            Belt belt
    ) {
    }

    public void updateGrade(Grade grade, Belt belt) {
        this.grade = grade;
        this.belt = belt;
    }

}
