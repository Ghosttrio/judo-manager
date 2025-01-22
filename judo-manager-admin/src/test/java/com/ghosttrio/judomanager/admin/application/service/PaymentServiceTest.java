package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;
import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import com.ghosttrio.judomanager.admin.application.port.out.PaymentClientPort;
import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PaymentServiceTest extends MonkeySupport {

    @Mock
    private PaymentClientPort paymentClientPort;
    @Mock
    private Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    @InjectMocks
    private PaymentService paymentService;
    @Mock
    private CircuitBreaker circuitBreaker;

    @Test
    void 결제_전체_조회_모듈이_정상응답_해야_한다() {
        List<Payment> payments = monkey.giveMe(Payment.class, 3);
        when(circuitBreakerFactory.create("paymentCB")).thenReturn(circuitBreaker);
        when(circuitBreaker.run(any(), any())).thenReturn(payments);

        List<Payment> result = paymentService.findAll();
        assertNotNull(result);
    }
}