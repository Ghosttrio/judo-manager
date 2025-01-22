package com.ghostrio.judomanager.apigateway.filter;

import com.ghostrio.judomanager.apigateway.error.JudoManagerGatewayException;
import com.ghostrio.judomanager.apigateway.property.JwtTokenProperty;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static com.ghostrio.judomanager.apigateway.error.GatewayErrorCode.*;
import static com.ghostrio.judomanager.apigateway.filter.AuthorizationFilter.Config;

@Slf4j
@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<Config> {

    private final JwtTokenProperty jwtTokenProperty;

    public AuthorizationFilter(JwtTokenProperty jwtTokenProperty) {
        super(Config.class);
        this.jwtTokenProperty = jwtTokenProperty;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            HttpHeaders headers = request.getHeaders();
            validateHeader(headers);
            validateJwt(headers);
            return chain.filter(exchange);
        };
    }

    private void validateHeader(HttpHeaders headers) {
        if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {
            throw new JudoManagerGatewayException(AUTHORIZATION_HEADER_NOT_FOUND);
        }
    }

    private void validateJwt(HttpHeaders headers) {
        try {
            checkTokenValue(extractToken(headers));
        } catch (ExpiredJwtException |
                 MalformedJwtException |
                 UnsupportedJwtException |
                 IllegalArgumentException |
                 NullPointerException e) {
            throw new JudoManagerGatewayException(INVALID_TOKEN);
        }
    }

    private String extractToken(HttpHeaders headers) {
        List<String> authorizations = headers.get(HttpHeaders.AUTHORIZATION);
        String authorizationHeader = Objects.requireNonNull(authorizations).get(0);
        return authorizationHeader.replace("Bearer", "");
    }

    private void checkTokenValue(String token) {
        String subject = Jwts.parser()
                .setSigningKey(jwtTokenProperty.getSecret())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        if (subject == null || subject.isEmpty()) {
            throw new JudoManagerGatewayException(EMPTY_TOKEN);
        }
    }

    public static class Config {
    }
}