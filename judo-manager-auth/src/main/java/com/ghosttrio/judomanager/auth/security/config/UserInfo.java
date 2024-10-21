package com.ghosttrio.judomanager.auth.security.config;

import lombok.Data;

@Data
public class UserInfo {

    private String id;
    private String password;
    private String role;
}
