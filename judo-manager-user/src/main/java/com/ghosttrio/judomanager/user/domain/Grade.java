package com.ghosttrio.judomanager.user.domain;


public enum Grade {
    KYU9,
    KYU8,
    KYU7,
    KYU6,
    KYU5,
    KYU4,
    KYU3,
    KYU2,
    KYU1,
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
