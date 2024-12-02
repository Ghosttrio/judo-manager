package com.judomanager.chat.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"success.html", "data"})
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 데이터 제외
public class JMResponse<T> {
    private final Boolean success;
    private final T data;

    public JMResponse(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public static <T> JMResponse<T> ok(T data) {
        return new JMResponse<>(true, data);
    }

    public static JMResponse<Void> ok() {
        return new JMResponse<>(true, null);
    }
}
