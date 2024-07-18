package com.judomanager.api.presentation.payment;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.payment.service.LoadPaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
@Tag(name = "[Payment API]")
public class LoadPaymentController {

    private final LoadPaymentService loadPaymentService;

    /** PG사(Tosspayment) 연동 */
    @GetMapping("/confirm")
    public JMResponse<String> confirmPayment(@RequestBody String jsonBody) {
        String result = loadPaymentService.loadPaymentWidget(jsonBody);
        return JMResponse.ok(result);
    }
}
