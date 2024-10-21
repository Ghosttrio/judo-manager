//package com.ghosttrio.judomanager.auth.security;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.management.JMException;
//import java.util.Optional;
//
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findById(Long.valueOf(id));
//        return user.map(this::createUserDetails)
//                .orElseThrow(() -> new JMException(ErrorCode.USER_NOT_FOUND));
//    }
//
//    private UserDetails createUserDetails(User user) {
//        return new CustomUserDetails(user.getId(), user.getEmail());
//    }
//
//}