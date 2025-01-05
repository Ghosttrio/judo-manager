package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity;

import com.ghosttrio.judomanager.user.common.exception.JMException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GradeTest {

    @Test
    void 프로모션_메서드를_실행하면_다음_등급으로_리턴되어야_한다() {
        Grade grade = Grade.DAN1;
        Grade[] grades = Grade.values();
        int ordinal = grade.ordinal() + 1;
        Grade result = grades[ordinal];
        Assertions.assertEquals(Grade.DAN2, result);
    }

    @Test
    void 단의_등급이_10단인_경우는_승급할_수_없다() {
        Assertions.assertThrows(JMException.class, Grade.DAN10::promotion);
    }

}