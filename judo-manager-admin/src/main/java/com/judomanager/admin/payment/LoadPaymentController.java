package com.judomanager.admin.payment;

import com.judomanager.common.exception.JMResponse;
import com.judomanager.domain.payment.domain.Payment;
import com.judomanager.domain.payment.service.LoadPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/v1/payments")
@Tag(name = "관리자 결제 내역 조회 컨트롤러")
public class LoadPaymentController {

    private final LoadPaymentService loadPaymentService;

    @Tag(name = "관리자 결제 내역 전체 조회 API")
    @Operation(summary = "유도 매니저에 등록된 모든 결제 내역을 조회한다.")
    @GetMapping
    public JMResponse<List<Payment>> loadAllPayment(){
        List<Payment> result = loadPaymentService.findAll();
        return JMResponse.ok(result);
    }

}
