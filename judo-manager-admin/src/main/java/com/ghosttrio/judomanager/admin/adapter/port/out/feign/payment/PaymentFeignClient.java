package com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;

@FeignClient(
	name = "PaymentFeignClient", url = "http://localhost:8000/api/v1/payments"
)
public interface PaymentFeignClient {
	@GetMapping
	List<Payment> findAll();
}
