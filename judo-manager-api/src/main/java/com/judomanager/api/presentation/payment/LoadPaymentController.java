package com.judomanager.api.presentation.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.payment.service.LoadPaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
@Tag(name = "결제 조회 컨트롤러")
public class LoadPaymentController {

    private final LoadPaymentService loadPaymentService;

    /** PG사(Tosspayment) 연동 */
    @RequestMapping(value = "/confirm")
    public JMResponse<String> confirmPayment(@RequestBody String jsonBody) {
        String result = loadPaymentService.loadPaymentWidget(jsonBody);
        return JMResponse.ok(result);
    }
}
