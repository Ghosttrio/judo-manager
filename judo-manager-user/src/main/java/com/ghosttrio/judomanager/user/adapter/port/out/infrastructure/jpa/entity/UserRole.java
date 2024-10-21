package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    MASTER("관장님"),
    MEMBER("회원");

    private final String role;

}
