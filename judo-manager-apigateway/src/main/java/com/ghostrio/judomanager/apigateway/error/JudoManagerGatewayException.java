package com.ghostrio.judomanager.apigateway.error;

import lombok.Getter;

@Getter
public class JudoManagerGatewayException extends RuntimeException {

    private final GatewayErrorCode errorCode;

    public JudoManagerGatewayException(GatewayErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
