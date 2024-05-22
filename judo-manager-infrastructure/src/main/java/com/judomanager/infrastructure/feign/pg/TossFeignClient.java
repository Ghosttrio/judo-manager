package com.judomanager.infrastructure.feign.pg;

import com.judomanager.infrastructure.config.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "TossFeignClient",
        url = "https://api.tosspayments.com/v1/payments/confirm",
        configuration = FeignConfig.class
)
public interface TossFeignClient {

    @PostMapping
    Object confirmPayment(@RequestHeader("Authorization") String authorization,
                          @RequestBody RequestDto request);
}