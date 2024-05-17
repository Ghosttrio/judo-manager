package com.judomanager.common.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

@Schema(name = "공통 에러 응답")
public record ErrorResponse(
        @Schema(name = "HTTP 상태")
        HttpStatus status,
        @Schema(name = "에러")
        String error,
        @Schema(name = "에러 메시지")
        String message
) {
    public static ErrorResponse from(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getHttpStatus(), errorCode.name(), errorCode.getMessage());
    }

    public static ErrorResponse withMessage(ErrorCode errorCode, String message) {
        return new ErrorResponse(errorCode.getHttpStatus(), errorCode.name(), message);
    }
}