package com.judomanager.api.presentation.payment.request;

public record CreateProductRequest(
        Long dojoId,
        String name,
        String amount
) {
}
