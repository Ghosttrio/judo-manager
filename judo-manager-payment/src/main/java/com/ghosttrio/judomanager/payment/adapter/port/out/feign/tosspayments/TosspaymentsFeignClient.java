package com.ghosttrio.judomanager.payment.adapter.port.out.feign.tosspayments;

import com.ghosttrio.judomanager.payment.adapter.port.in.ApprovalPaymentController;
import com.ghosttrio.judomanager.payment.adapter.port.in.ApprovalPaymentController.ConfirmRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "TosspaymentsFeignClient", url = "https://api.tosspayments.com/v1/payments"
)
public interface TosspaymentsFeignClient {

    @PostMapping(value = "/confirm", consumes = "application/json", produces = "application/json")
    Object confirm(@RequestHeader("Authorization") String auth,
                   @RequestHeader("Content-Type") String type,
                   @RequestBody ConfirmRequest request);
}
