package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.application.port.out.DojoClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LoadDojoService {

    private final DojoClientPort dojoClientPort;
    private final CircuitBreakerFactory circuitBreakerFactory;

    public List<Dojo> findAll() {
        CircuitBreaker cb = circuitBreakerFactory.create("dojoCB");
        return cb.run(dojoClientPort::findAll, throwable -> List.of(new Dojo()));
    }
}
