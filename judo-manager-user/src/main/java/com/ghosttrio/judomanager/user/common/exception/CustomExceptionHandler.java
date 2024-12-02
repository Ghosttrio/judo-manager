package com.ghosttrio.judomanager.user.common.exception;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(JMException.class)
	public ResponseEntity<ErrorResponse> judoManagerExceptionHandler(JMException exception) {
		final ErrorCode errorCode = exception.getErrorCode();
		log.warn("Error Name : {} Error Message : {}", errorCode.name(), errorCode.getMessage());
		return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.from(errorCode));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(BAD_REQUEST)
	public ErrorResponse handleMethodArgumentNotValidException(
		MethodArgumentNotValidException exception,
		HttpServletRequest request
	) {
		String message = exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		log.warn("URL : {} Error Message : {}", request.getRequestURI(), message);
		return ErrorResponse.withMessage(ErrorCode.METHOD_BAD_REQUEST, message);
	}

}
