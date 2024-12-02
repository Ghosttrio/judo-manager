package com.ghosttrio.judomanager.auth.common.exception;

import lombok.Getter;

@Getter
public class JMException extends RuntimeException {

    private final ErrorCode errorCode;

    public JMException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public JMException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }
    private JMException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public static JMException withCode(ErrorCode errorCode, Long code) {
        String message = errorCode.getMessage() + " [Request Code : " + code + "]";
        return new JMException(message, errorCode);
    }

    public int getHttpStatus() {
        return errorCode.getHttpStatus().value();
    }
}