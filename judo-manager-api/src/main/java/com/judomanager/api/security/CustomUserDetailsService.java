package com.judomanager.api.security;

import com.judomanager.common.exception.JMException;
import com.judomanager.domain.user.domain.User;
import com.judomanager.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.judomanager.common.exception.ErrorCode.USER_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(Long.valueOf(id));
        return user.map(this::createUserDetails)
                .orElseThrow(() -> new JMException(USER_NOT_FOUND));
    }

    private UserDetails createUserDetails(User user) {
        return new CustomUserDetails(user.getId(), user.getEmail());
    }

}