package com.ghostrio.judomanager.apigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public LoggingFilter(KafkaTemplate<String, String> kafkaTemplate) {
        super(Config.class);
        this.kafkaTemplate = kafkaTemplate;
    }

    public static class Config {
    }

    @Override
    public GatewayFilter apply(LoggingFilter.Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
            kafkaTemplate.send("log-topic", String.valueOf(request.getURI()));
            return chain.filter(exchange).then(Mono.fromRunnable(
                    () -> log.info("==========> 응답 코드 : {}", response.getStatusCode())));
        };
    }
}
