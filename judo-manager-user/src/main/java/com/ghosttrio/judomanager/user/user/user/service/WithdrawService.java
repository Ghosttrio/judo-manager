//package com.ghosttrio.judomanager.user.user.user.service;
//
//import com.ghosttrio.judomanager.user.user.user.domain.User;
//import com.judomanager.infrastructure.redis.RedisService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class WithdrawService {
//
//    private final LoadUserService loadUserService;
//    private final RedisService redisService;
//
//    @Transactional
//    public void withdraw(Long userId){
//        User user = loadUserService.findById(userId);
//        String email = user.getEmail();
//        redisService.deleteValues(email);
//        user.withDrawUser();
//    }
//}
