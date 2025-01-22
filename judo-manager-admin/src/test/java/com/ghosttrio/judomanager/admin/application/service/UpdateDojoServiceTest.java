package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.application.port.out.DojoClientPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateDojoServiceTest {
    @Mock
    private DojoClientPort dojoClientPort;
    @Mock
    private Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    @Mock
    private CircuitBreaker circuitBreaker;
    @InjectMocks
    private UpdateDojoService updateDojoService;

    @Test
    void 도장_정보_업데이트가_성공해야_한다() {
        Long dojoId = 1L;
        DojoState state = DojoState.PENDING;
        doNothing().when(dojoClientPort).update(dojoId, state);

        updateDojoService.update(dojoId, state);

        verify(dojoClientPort, times(1)).update(dojoId, state);
    }

}

