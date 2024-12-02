package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserClientPort userClientPort;
    private final CircuitBreakerFactory circuitBreakerFactory;

    @Transactional
    public void ban(Long userId) {
        CircuitBreaker cb = circuitBreakerFactory.create("dojoCB");
        Supplier<Void> deleteAction = () -> {
            userClientPort.updateUserStatus(userId);
            return null;
        };
        cb.run(deleteAction);
    }

}
