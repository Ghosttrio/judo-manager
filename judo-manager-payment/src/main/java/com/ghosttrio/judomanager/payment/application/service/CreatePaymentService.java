package com.ghosttrio.judomanager.payment.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ghosttrio.judomanager.payment.application.port.out.ProductJpaPort;
import com.ghosttrio.judomanager.payment.domain.Product;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreatePaymentService {

	private final ProductJpaPort productJpaPort;

	@Transactional
	public void create(Long dojoId, String name, String amount) {
		Product product = Product.create(dojoId, name, amount);
		productJpaPort.save(product);
	}
}
