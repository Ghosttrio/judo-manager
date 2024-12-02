package com.ghosttrio.judomanager.admin.application.port.out;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;

import java.util.List;

public interface PaymentClientPort {
    List<Payment> findAll();
}
