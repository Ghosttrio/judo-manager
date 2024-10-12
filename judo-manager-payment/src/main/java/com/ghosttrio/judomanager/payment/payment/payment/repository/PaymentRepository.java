package com.ghosttrio.judomanager.payment.payment.payment.repository;

import com.ghosttrio.judomanager.payment.payment.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
