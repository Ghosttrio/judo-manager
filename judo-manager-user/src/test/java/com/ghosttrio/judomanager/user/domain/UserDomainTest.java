package com.ghosttrio.judomanager.user.domain;

import com.ghosttrio.judomanager.user.common.MonkeySupport;
import com.ghosttrio.judomanager.user.domain.UserDomain.PromotionResult;
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

    @Test
    void 회원_탈퇴_시_유저_상태와_도장_정보_프로필정보가_제거되어야_한다() {
        UserDomain userDomain = monkey.giveMeBuilder(UserDomain.class)
                .set("state", UserState.ACTIVATED)
                .sample();

        UserDomain withDrawUser = userDomain.withDrawUser();

        assertEquals(UserState.DELETED, withDrawUser.getState());
        assertEquals(0L, withDrawUser.getDojoId());
        assertEquals("탈퇴유저", withDrawUser.getUserProfile().getNickname());
        assertEquals("", withDrawUser.getUserProfile().getEmail());
    }

    @Test
    void 승급이_완료되면_등급이_올라가고_벨트가_등급에_맞게_수정되어야_한다() {
        UserDomain white1 = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.KYU9)
                .set("belt", Belt.WHITE)
                .sample();
        UserDomain white2 = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.KYU6)
                .set("belt", Belt.WHITE)
                .sample();
        UserDomain yellow = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.KYU5)
                .set("belt", Belt.YELLOW)
                .sample();
        UserDomain orange = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.KYU4)
                .set("belt", Belt.ORANGE)
                .sample();
        UserDomain green = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.KYU3)
                .set("belt", Belt.GREEN)
                .sample();
        UserDomain blue = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.KYU2)
                .set("belt", Belt.BLUE)
                .sample();
        UserDomain brown = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.KYU1)
                .set("belt", Belt.BROWN)
                .sample();
        UserDomain black1 = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.DAN1)
                .set("belt", Belt.BLACK)
                .sample();
        UserDomain black2 = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.DAN5)
                .set("belt", Belt.BLACK)
                .sample();
        UserDomain redAndWhite1 = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.DAN6)
                .set("belt", Belt.RED_AND_WHITE)
                .sample();
        UserDomain redAndWhite2 = monkey.giveMeBuilder(UserDomain.class)
                .set("grade", Grade.DAN8)
                .set("belt", Belt.RED_AND_WHITE)
                .sample();

        PromotionResult result1 = white1.promotionGrade();
        PromotionResult result2 = white2.promotionGrade();

        PromotionResult result3 = yellow.promotionGrade();

        PromotionResult result4 = orange.promotionGrade();

        PromotionResult result5 = green.promotionGrade();

        PromotionResult result6 = blue.promotionGrade();

        PromotionResult result7 = brown.promotionGrade();

        PromotionResult result8 = black1.promotionGrade();
        PromotionResult result9 = black2.promotionGrade();

        PromotionResult result10 = redAndWhite1.promotionGrade();
        PromotionResult result11 = redAndWhite2.promotionGrade();

        assertEquals(Grade.KYU8, result1.grade());
        assertEquals(Belt.WHITE, result1.belt());

        assertEquals(Grade.KYU5, result2.grade());
        assertEquals(Belt.YELLOW, result2.belt());

        assertEquals(Grade.KYU4, result3.grade());
        assertEquals(Belt.ORANGE, result3.belt());

        assertEquals(Grade.KYU3, result4.grade());
        assertEquals(Belt.GREEN, result4.belt());

        assertEquals(Grade.KYU2, result5.grade());
        assertEquals(Belt.BLUE, result5.belt());

        assertEquals(Grade.KYU1, result6.grade());
        assertEquals(Belt.BROWN, result6.belt());

        assertEquals(Grade.DAN1, result7.grade());
        assertEquals(Belt.BLACK, result7.belt());

        assertEquals(Grade.DAN2, result8.grade());
        assertEquals(Belt.BLACK, result8.belt());
        assertEquals(Grade.DAN6, result9.grade());
        assertEquals(Belt.RED_AND_WHITE, result9.belt());

        assertEquals(Grade.DAN7, result10.grade());
        assertEquals(Belt.RED_AND_WHITE, result10.belt());
        assertEquals(Grade.DAN9, result11.grade());
        assertEquals(Belt.RED, result11.belt());
    }


}