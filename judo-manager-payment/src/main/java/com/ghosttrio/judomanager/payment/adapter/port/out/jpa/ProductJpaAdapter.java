package com.ghosttrio.judomanager.payment.adapter.port.out.jpa;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.payment.application.port.out.ProductJpaPort;
import com.ghosttrio.judomanager.payment.domain.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductJpaAdapter implements ProductJpaPort {

	private final ProductRepository productRepository;

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}
}
