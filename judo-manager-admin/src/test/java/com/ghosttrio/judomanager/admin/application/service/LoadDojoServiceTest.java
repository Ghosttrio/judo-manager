package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.application.port.out.DojoClientPort;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoadDojoServiceTest extends MonkeySupport {

    @Mock
    private DojoClientPort dojoClientPort;
    @Mock
    private Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    @Mock
    private CircuitBreaker circuitBreaker;
    @InjectMocks
    private LoadDojoService loadDojoService;

    @Test
    void 도장_조회_요청의_결과가_정상_출력되어야_한다() {
        List<Dojo> dojos = monkey.giveMe(Dojo.class, 3);
        when(circuitBreakerFactory.create("dojoCB")).thenReturn(circuitBreaker);
        when(circuitBreaker.run(any(), any())).thenReturn(dojos);
        List<Dojo> result = loadDojoService.findAll();
        assertNotNull(result);
    }

    @Test
    void 도장_조회_모듈이_응답을_하지_않을_경우_빈객체_배열을_리턴한다() {
        when(circuitBreakerFactory.create("dojoCB")).thenReturn(circuitBreaker);
        when(circuitBreaker.run(any(), any())).thenThrow(new RuntimeException("Service unavailable"));
        assertThrows(Exception.class, () -> loadDojoService.findAll());
    }
}