package com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Approval {
    APPROVED("승인됨"),
    REJECT("거절"),
    PENDING("대기중");

    private final String value;
}
