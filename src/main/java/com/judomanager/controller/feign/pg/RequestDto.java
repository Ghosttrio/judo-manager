package com.judomanager.controller.feign.pg;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDto {
    private String orderId;
    private String amount;
    private String paymentKey;

    @Builder
    public RequestDto(String orderId, String amount, String paymentKey) {
        this.orderId = orderId;
        this.amount = amount;
        this.paymentKey = paymentKey;
    }
}