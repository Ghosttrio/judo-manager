package com.ghosttrio.judomanager.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserState {
    ACTIVATED("활성화 유저"),
    DEACTIVATED("비활성화 유저"),
    DELETED("탈퇴 유저");
    
    private final String message;
}
