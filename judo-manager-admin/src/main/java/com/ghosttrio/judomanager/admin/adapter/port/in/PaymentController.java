package com.ghosttrio.judomanager.admin.adapter.port.in;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.payment.model.Payment;
import com.ghosttrio.judomanager.admin.application.port.in.payment.LoadPaymentUseCase;
import com.ghosttrio.judomanager.admin.config.exception.JMResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admins/payments")
@Tag(name = "[ADMIN API]")
public class PaymentController {

	private final LoadPaymentUseCase loadPaymentUseCase;

	@Operation(summary = "유도 매니저에 등록된 모든 결제 내역을 조회한다.")
	@GetMapping
	public JMResponse<List<Payment>> loadAllPayment() {
		List<Payment> result = loadPaymentUseCase.execute();
		return JMResponse.ok(result);
	}
}
