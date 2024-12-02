package com.ghosttrio.judomanager.payment.adapter.port.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ghosttrio.judomanager.payment.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
