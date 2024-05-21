package com.judomanager.domain.domain.attendance;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Approval {
    APPROVED("승인됨"),
    REJECT("거절"),
    PENDING("대기중");

    private final String value;
}
