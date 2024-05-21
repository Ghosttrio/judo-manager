package com.judomanager.domain.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    MASTER("관장님"),
    MEMBER("회원");
    
    private final String role;

}
