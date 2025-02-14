package com.ghosttrio.judomanager.admin.application.service;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;
import com.ghosttrio.judomanager.admin.application.port.out.PaymentClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentClientPort paymentClientPort;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    public List<Payment> findAll() {
        CircuitBreaker cb = circuitBreakerFactory.create("paymentCB");
        return cb.run(paymentClientPort::findAll, throwable -> List.of(new Payment(null)));
    }
}
