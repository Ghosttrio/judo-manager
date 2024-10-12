package com.ghosttrio.judomanager.payment.payment.request;

public record CreateProductRequest(
        Long dojoId,
        String name,
        String amount
) {
}
