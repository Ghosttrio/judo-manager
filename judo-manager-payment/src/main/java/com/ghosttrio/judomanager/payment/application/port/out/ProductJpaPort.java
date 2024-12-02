package com.ghosttrio.judomanager.payment.application.port.out;

import com.ghosttrio.judomanager.payment.domain.Product;

public interface ProductJpaPort {
	void save(Product product);
}
