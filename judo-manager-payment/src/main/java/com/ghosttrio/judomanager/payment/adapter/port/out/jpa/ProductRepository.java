package com.ghosttrio.judomanager.payment.adapter.port.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghosttrio.judomanager.payment.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
