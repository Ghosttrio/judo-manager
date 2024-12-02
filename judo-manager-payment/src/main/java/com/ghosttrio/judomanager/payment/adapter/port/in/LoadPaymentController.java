package com.ghosttrio.judomanager.payment.adapter.port.in;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghosttrio.judomanager.payment.application.service.LoadPaymentService;
import com.ghosttrio.judomanager.payment.common.exception.JMResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
@Tag(name = "[Payment API]")
public class LoadPaymentController {

	private final LoadPaymentService loadPaymentService;

	/** PG사(Tosspayment) 연동 */
	@RequestMapping(value = "/confirm")
	public JMResponse<String> confirmPayment(@RequestBody String jsonBody) {
		String result = loadPaymentService.loadPaymentWidget(jsonBody);
		return JMResponse.ok(result);
	}
}
