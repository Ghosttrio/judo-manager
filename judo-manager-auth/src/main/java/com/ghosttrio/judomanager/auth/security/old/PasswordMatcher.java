//package com.ghosttrio.judomanager.auth.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.management.JMException;
//
//@Component
//@RequiredArgsConstructor
//public class PasswordMatcher {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public void check(String password, String anotherPassword) {
//        boolean result = passwordEncoder.matches(password, anotherPassword);
//        if (!result) {
//            throw new JMException(ErrorCode.PASSWORD_INCORRECT_REQUEST);
//        }
//    }
//}
