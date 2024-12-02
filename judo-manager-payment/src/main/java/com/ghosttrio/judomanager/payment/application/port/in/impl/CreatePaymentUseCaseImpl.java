package com.ghosttrio.judomanager.payment.application.port.in.impl;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.payment.application.port.in.CreatePaymentUseCase;
import com.ghosttrio.judomanager.payment.application.service.CreatePaymentService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {

	private final CreatePaymentService createPaymentService;

	@Override
	public void execute(Long dojoId, String name, String amount) {
		createPaymentService.create(dojoId, name, amount);
	}
}
