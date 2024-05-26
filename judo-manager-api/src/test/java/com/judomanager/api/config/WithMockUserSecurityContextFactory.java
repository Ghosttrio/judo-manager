package com.judomanager.api.config;

import com.judomanager.api.security.CustomUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.Collections;


public class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<ApiTest> {

    private static final UserDetails user = new CustomUserDetails(1L,"testEmail");

    @Override
    public SecurityContext createSecurityContext(ApiTest annotation) {
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        return context;
    }
}