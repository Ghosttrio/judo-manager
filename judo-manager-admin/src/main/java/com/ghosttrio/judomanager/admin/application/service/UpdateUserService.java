package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserClientPort userClientPort;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

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
