package com.ghosttrio.judomanager.user.application.service;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.redis.RedisService;
import com.ghosttrio.judomanager.user.application.port.out.UserPort;
import com.ghosttrio.judomanager.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WithdrawService {

    private final UserPort userPort;
    private final RedisService redisService;

    @Transactional
    public void withdraw(Long userId){
        User user = userPort.findById(userId);
        String email = user.getEmail();
        redisService.deleteValues(email);
        user.withDrawUser();
    }
}
