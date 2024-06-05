package com.judomanager.domain.user.service;

import com.judomanager.domain.user.domain.User;
import com.judomanager.infrastructure.redis.RedisServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WithdrawService {

    private final LoadUserService loadUserService;
    private final RedisServiceImpl redisServiceImpl;

    @Transactional
    public void withdraw(Long userId){
        User user = loadUserService.findById(userId);
        String email = user.getEmail();
        redisServiceImpl.deleteValues(email);
        user.withDrawUser();
    }
}
