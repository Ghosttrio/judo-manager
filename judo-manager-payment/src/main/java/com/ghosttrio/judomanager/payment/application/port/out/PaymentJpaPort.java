package com.ghosttrio.judomanager.payment.application.port.out;

import java.util.List;

import com.ghosttrio.judomanager.payment.domain.Payment;

public interface PaymentJpaPort {
	void save(Payment payment);

	List<Payment> findAll();
}
