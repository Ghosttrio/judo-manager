package com.ghostrio.judomanager.apigateway.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.adapter.DefaultServerWebExchange;
import reactor.core.publisher.Mono;

import static java.net.URI.create;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoggingFilterTest {
    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;
    @Mock
    private ServerWebExchange exchange;
    @Mock
    private ServerHttpRequest request;
    @Mock
    private ServerHttpResponse response;
    @Mock
    private GatewayFilterChain filterChain;
    @InjectMocks
    private LoggingFilter loggingFilter;

    @BeforeEach
    void setup() {
        loggingFilter = new LoggingFilter(kafkaTemplate);
    }

    @Test
    void 로깅_필터가_정상작동_해야_한다() {
        // Given
        String uri = "http://localhost/test";
        when(exchange.getRequest()).thenReturn(request);
        when(request.getURI()).thenReturn(create(uri));
        when(exchange.getResponse()).thenReturn(response);
        when(response.getStatusCode()).thenReturn(HttpStatus.OK);
        Mono<Void> emptyMono = Mono.empty();
        when(filterChain.filter(exchange)).thenReturn(emptyMono);

        // When
        GatewayFilter filter = loggingFilter.apply(new LoggingFilter.Config());
        filter.filter(exchange, filterChain).block();

        // Then
        // KafkaTemplate의 send 메서드가 호출되었는지 검증
        verify(kafkaTemplate, times(1)).send(eq("log-topic"), eq(uri));
        // 필터 체인이 정상적으로 호출되었는지 검증
        verify(filterChain).filter(exchange);
    }
}