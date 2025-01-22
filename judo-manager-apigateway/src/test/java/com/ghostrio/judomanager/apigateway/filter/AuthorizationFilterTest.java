package com.ghostrio.judomanager.apigateway.filter;

import com.ghostrio.judomanager.apigateway.property.JwtTokenProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

@ExtendWith(MockitoExtension.class)
class AuthorizationFilterTest {

    @Mock
    private JwtTokenProperty jwtTokenProperty;
    @InjectMocks
    private AuthorizationFilter authorizationFilter;
    @Mock
    private ServerWebExchange exchange;
    @Mock
    private ServerHttpRequest request;
    @Mock
    private GatewayFilterChain chain;
    @Mock
    private HttpHeaders headers;

    @BeforeEach
    void setup() {
        authorizationFilter = new AuthorizationFilter(jwtTokenProperty);
    }

}