package com.ghosttrio.judomanager.auth.application.service;

import com.ghosttrio.judomanager.auth.domain.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final AuthenticationLoader authenticationLoader;
    private final RedisService redisService;

    public void logout(String accessToken) {
        Authentication authentication = authenticationLoader.getAuthentication(resolveToken(accessToken));
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        redisService.deleteValues(principal.getUsername());
    }

    private String resolveToken(String accessToken) {
        if (StringUtils.hasText(accessToken) && accessToken.startsWith("Bearer ")) {
            return accessToken.substring(7);
        }
        return null;
    }
}
