package com.ghosttrio.judomanager.payment.application.port.in;

public interface CreatePaymentUseCase {
	void execute(Long dojoId, String name, String amount);
}
