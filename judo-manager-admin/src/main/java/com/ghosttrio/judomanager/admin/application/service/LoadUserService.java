package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadUserService {

    private final UserClientPort userClientPort;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public List<User> findAll() {
        CircuitBreaker cb = circuitBreakerFactory.create("userCB");
        return cb.run(userClientPort::findAll, throwable -> List.of(new User()));
    }
}
