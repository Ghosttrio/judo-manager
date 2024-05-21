package com.judomanager.api.security.jwt;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JwtResolver {

    public String resolveToken(String bearerToken) {
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}