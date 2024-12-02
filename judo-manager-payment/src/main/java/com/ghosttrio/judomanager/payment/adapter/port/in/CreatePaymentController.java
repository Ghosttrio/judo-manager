package com.ghosttrio.judomanager.payment.adapter.port.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghosttrio.judomanager.payment.adapter.port.in.request.CreateProductRequest;
import com.ghosttrio.judomanager.payment.application.port.in.CreatePaymentUseCase;
import com.ghosttrio.judomanager.payment.common.exception.JMResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
@Tag(name = "[Payment API]")
public class CreatePaymentController {

	private final CreatePaymentUseCase createPaymentUseCase;

	/** 도장 별 결제 정보 등록, 개월 수, 금액 */
	// 만약 회원권이 있는데 추가로 결제하면 LessonPass 의 시간 업데이트
	@PostMapping
	public JMResponse<Void> createProduct(@RequestBody CreateProductRequest request) {
		createPaymentUseCase.execute(request.dojoId(), request.name(), request.amount());
		return JMResponse.ok();
	}
}
