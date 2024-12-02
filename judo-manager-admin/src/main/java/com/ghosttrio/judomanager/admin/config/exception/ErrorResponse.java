package com.ghosttrio.judomanager.admin.config.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(
	HttpStatus status,
	String error,
	String message
) {
	public static ErrorResponse from(ErrorCode errorCode) {
		return new ErrorResponse(errorCode.getHttpStatus(), errorCode.name(), errorCode.getMessage());
	}

	public static ErrorResponse withMessage(ErrorCode errorCode, String message) {
		return new ErrorResponse(errorCode.getHttpStatus(), errorCode.name(), message);
	}
}
