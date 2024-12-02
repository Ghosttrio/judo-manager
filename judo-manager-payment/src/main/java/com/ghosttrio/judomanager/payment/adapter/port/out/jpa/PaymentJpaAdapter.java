package com.ghosttrio.judomanager.payment.adapter.port.out.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.payment.application.port.out.PaymentJpaPort;
import com.ghosttrio.judomanager.payment.domain.Payment;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentJpaAdapter implements PaymentJpaPort {

	private final PaymentRepository paymentRepository;

	@Override
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}
}
