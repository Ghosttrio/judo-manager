package com.ghosttrio.judomanager.user.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Grade {

    //todo 벨트랑 단을 합치는 방법?
    KYU1,
    KYU2,
    KYU3,
    KYU4,
    KYU5,
    KYU6,
    KYU7,
    KYU8,
    KYU9,
    DAN1,
    DAN2,
    DAN3,
    DAN4,
    DAN5,
    DAN6,
    DAN7,
    DAN8,
    DAN9,
    DAN10;

    public Grade promotion() {
        Grade[] grades = Grade.values();
        int ordinal = this.ordinal() + 1;
        return grades[ordinal];
    }

}
