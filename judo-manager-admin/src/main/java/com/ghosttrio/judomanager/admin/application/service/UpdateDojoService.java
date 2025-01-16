package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.application.port.out.DojoClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UpdateDojoService {

    private final DojoClientPort dojoClientPort;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    public void executeUpdate(Long dojoId, DojoState state) {
        dojoClientPort.update(dojoId, state);
    }

    @Transactional
    public void update(Long dojoId, DojoState state) {
        CircuitBreaker cb = circuitBreakerFactory.create("dojoCB");
        Supplier<Void> deleteAction = () -> {
            executeUpdate(dojoId, state);
            return null;
        };
        cb.run(deleteAction);
    }

}
