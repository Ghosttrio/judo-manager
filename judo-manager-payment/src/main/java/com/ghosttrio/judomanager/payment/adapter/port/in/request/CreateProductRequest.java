package com.ghosttrio.judomanager.payment.adapter.port.in.request;

public record CreateProductRequest(
	Long dojoId,
	String name,
	String amount
) {
}
