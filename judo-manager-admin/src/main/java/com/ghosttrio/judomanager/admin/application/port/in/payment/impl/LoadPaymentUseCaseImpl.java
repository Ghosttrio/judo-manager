package com.ghosttrio.judomanager.admin.application.port.in.payment.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;
import com.ghosttrio.judomanager.admin.application.port.in.payment.LoadPaymentUseCase;
import com.ghosttrio.judomanager.admin.application.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadPaymentUseCaseImpl implements LoadPaymentUseCase {

    private final PaymentService paymentService;

    @Override
    public List<Payment> execute() {
        return paymentService.findAll();
    }
}
