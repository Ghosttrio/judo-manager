package com.ghostrio.judomanager.apigateway.error;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GatewayErrorCode {

	AUTHORIZATION_HEADER_NOT_FOUND(NOT_FOUND, "Authorization 형식을 찾지 못했습니다."),
	BEARER_NOT_FOUND(NOT_FOUND, "Bearer 형식을 찾지 못했습니다."),
	EMPTY_TOKEN(BAD_REQUEST, "비어있는 토큰입니다."),
	INVALID_BEARER_TOKEN(BAD_REQUEST, "유효한 Bearer 토큰의 형식이 아닙니다."),
	INVALID_SIGNATURE(BAD_REQUEST, "잘못된 서명입니다."),
	INVALID_TOKEN(BAD_REQUEST, "잘못된 토큰입니다."),
	EXPIRED_TOKEN(BAD_REQUEST, "만료된 토큰입니다."),
	UNSUPPORTED_TOKEN(BAD_REQUEST, "지원하지 않는 토큰입니다."),
	EXPIRED_REFRESH_TOKEN(BAD_REQUEST, "Refresh 토큰이 만료되었습니다. 다시 로그인을 시도하세요."),
	NOT_ALLOWED_URI(BAD_REQUEST, "허용되지 않은 주소입니다.");

	private final HttpStatus status;
	private final String message;
}
