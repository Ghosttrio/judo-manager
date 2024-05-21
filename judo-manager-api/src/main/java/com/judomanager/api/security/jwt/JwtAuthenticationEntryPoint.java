package com.judomanager.api.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.judomanager.common.common.exception.ErrorCode;
import com.judomanager.common.common.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.apache.commons.lang3.CharEncoding.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        Object exception = request.getAttribute("exception");
        if(exception instanceof ErrorCode){
            ErrorCode errorCode = (ErrorCode) exception;
            setResponse(response, errorCode);
            return;
        }
    }

    private void setResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(UTF_8);
        response.setStatus(errorCode.getHttpStatus().value());
        ErrorResponse error = ErrorResponse.from(errorCode);
        response.getWriter().write(mapper.writeValueAsString(error));
    }
}