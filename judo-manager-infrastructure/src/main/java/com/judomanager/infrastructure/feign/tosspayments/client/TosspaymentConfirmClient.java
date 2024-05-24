package com.judomanager.infrastructure.feign.tosspayments.client;

import com.judomanager.infrastructure.config.feign.FeignConfig;
import com.judomanager.infrastructure.feign.tosspayments.dto.TosspaymentConfirmRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "TosspaymentConfirmClient",
        url = "https://api.tosspayments.com/v1/payments/confirm",
        configuration = FeignConfig.class
)
public interface TosspaymentConfirmClient {

    @PostMapping
    Object confirmPayment(@RequestHeader("Authorization") String authorization,
                          @RequestBody TosspaymentConfirmRequest request);
}