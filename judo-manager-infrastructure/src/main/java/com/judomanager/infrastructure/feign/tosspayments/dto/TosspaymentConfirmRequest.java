package com.judomanager.infrastructure.feign.tosspayments.dto;

public record TosspaymentConfirmRequest(
        String orderId,
        String amount,
        String paymentKey
) {
}