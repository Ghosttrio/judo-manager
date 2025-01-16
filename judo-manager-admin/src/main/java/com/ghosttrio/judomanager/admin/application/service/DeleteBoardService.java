package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.application.port.out.BoardClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class DeleteBoardService {

    private final BoardClientPort boardClientPort;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @Transactional
    public void delete(Long boardId) {

        CircuitBreaker cb = circuitBreakerFactory.create("boardCB");
        Supplier<Void> deleteAction = () -> {
            executeDelete(boardId);
            return null;
        };
        cb.run(deleteAction);
    }

    private void executeDelete(Long boardId) {
        boardClientPort.deleteById(boardId);
    }
}


