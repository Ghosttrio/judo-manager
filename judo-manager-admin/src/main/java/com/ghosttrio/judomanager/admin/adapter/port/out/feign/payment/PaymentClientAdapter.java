package com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;
import com.ghosttrio.judomanager.admin.application.port.out.PaymentClientPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentClientAdapter implements PaymentClientPort {

	private final PaymentFeignClient paymentFeignClient;

	@Override
	public List<Payment> findAll() {
		return paymentFeignClient.findAll();
	}
}
