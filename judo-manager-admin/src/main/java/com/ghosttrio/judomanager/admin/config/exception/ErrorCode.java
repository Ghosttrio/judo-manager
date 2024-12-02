package com.ghosttrio.judomanager.admin.config.exception;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	// 400 요청 오류
	METHOD_BAD_REQUEST(BAD_REQUEST, "400"),

	// 500 서버 오류
	SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버 에러 입니다. 관리자에게 문의해주세요.");

	private final HttpStatus httpStatus;
	private final String message;

}
