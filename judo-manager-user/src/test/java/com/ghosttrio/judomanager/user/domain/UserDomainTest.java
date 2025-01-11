package com.ghosttrio.judomanager.user.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDomainTest {

    @Test
    void 프로모션_메서드를_실행하면_다음_등급으로_리턴되어야_한다() {
        Grade grade = Grade.DAN1;
        Grade[] grades = Grade.values();
        int ordinal = grade.ordinal() + 1;
        Grade result = grades[ordinal];
        assertEquals(Grade.DAN2, result);
    }


}