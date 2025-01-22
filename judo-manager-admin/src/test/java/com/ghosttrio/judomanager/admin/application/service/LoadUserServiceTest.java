package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;
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
class LoadUserServiceTest extends MonkeySupport {

    @Mock
    private UserClientPort userClientPort;
    @Mock
    private Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    @InjectMocks
    private LoadUserService loadUserService;
    @Mock
    private CircuitBreaker circuitBreaker;

    @Test
    void 유저_전체_조회_모듈이_정상응답_해야_한다() {
        List<User> users = monkey.giveMe(User.class, 3);
        when(circuitBreakerFactory.create("userCB")).thenReturn(circuitBreaker);
        when(circuitBreaker.run(any(), any())).thenReturn(users);

        List<User> result = loadUserService.findAll();
        assertNotNull(result);
    }
}