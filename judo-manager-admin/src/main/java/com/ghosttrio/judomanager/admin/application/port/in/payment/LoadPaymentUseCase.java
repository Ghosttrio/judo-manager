package com.ghosttrio.judomanager.admin.application.port.in.payment;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;

import java.util.List;

public interface LoadPaymentUseCase {
    List<Payment> execute();
}
