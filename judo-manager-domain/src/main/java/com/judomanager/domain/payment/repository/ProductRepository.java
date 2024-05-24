package com.judomanager.domain.payment.repository;

import com.judomanager.domain.payment.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
