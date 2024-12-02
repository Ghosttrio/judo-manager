package com.ghosttrio.judomanager.auth.security.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(name = "loadUserService", url = "http://localhost:8080/api/v1/users")
public interface LoadUserService {

    @GetMapping
    Optional<UserInfo> findByUserId(String userId);
}

