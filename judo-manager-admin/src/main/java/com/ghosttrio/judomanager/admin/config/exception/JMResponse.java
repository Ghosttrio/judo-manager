package com.ghosttrio.judomanager.admin.config.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"success.html", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public record JMResponse<T>(Boolean success, T data) {

	public static <T> JMResponse<T> ok(T data) {
		return new JMResponse<>(true, data);
	}

	public static JMResponse<Void> ok() {
		return new JMResponse<>(true, null);
	}
}
