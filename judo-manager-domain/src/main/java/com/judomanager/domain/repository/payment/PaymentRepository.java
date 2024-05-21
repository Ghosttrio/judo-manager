package com.judomanager.domain.repository.payment;

import com.judomanager.domain.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
