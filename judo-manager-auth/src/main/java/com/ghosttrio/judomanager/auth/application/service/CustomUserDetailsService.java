package com.ghosttrio.judomanager.auth.application.service;

import com.ghosttrio.judomanager.auth.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.auth.domain.CustomUserDetails;
import com.ghosttrio.judomanager.auth.security.config.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserClientPort userClientPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userClientPort.loadUserByUsername(username);
        return createUserDetails(userInfo);
    }

    private UserDetails createUserDetails(UserInfo userInfo) {
        return new CustomUserDetails(userInfo.getId(), userInfo.getPassword());
    }
}
