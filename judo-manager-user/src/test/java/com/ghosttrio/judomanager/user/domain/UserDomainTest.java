package com.ghosttrio.judomanager.user.domain;

import com.ghosttrio.judomanager.user.common.MonkeySupport;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDomainTest extends MonkeySupport {

    @Test
    void 프로모션_메서드를_실행하면_다음_등급으로_리턴되어야_한다() {
        Grade grade = Grade.DAN1;
        Grade[] grades = Grade.values();
        int ordinal = grade.ordinal() + 1;
        Grade result = grades[ordinal];
        assertEquals(Grade.DAN2, result);
    }

    @Test
    void 최초_유저_도메인_생성_시_초기화_상태로_생성되어야_한다() {
        UserProfile userProfile = monkey.giveMeOne(UserProfile.class);

        UserDomain userDomain = UserDomain.generateUserDomain(userProfile);

        assertEquals(userProfile, userDomain.getUserProfile());
        assertEquals(UserState.ACTIVATED, userDomain.getState());
        assertEquals(0L, userDomain.getDojoId());
        assertEquals(Belt.WHITE, userDomain.getBelt());
        assertEquals(Grade.KYU1, userDomain.getGrade());
    }


}