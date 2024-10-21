//package com.ghostrio.judomanager.apigateway.filter;
//
//import com.ghostrio.judomanager.apigateway.error.JudoManagerGatewayException;
//import com.ghostrio.judomanager.apigateway.property.JwtTokenProperty;
//import io.jsonwebtoken.Jwts;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Objects;
//
//import static com.ghostrio.judomanager.apigateway.error.GatewayErrorCode.*;
//import static com.ghostrio.judomanager.apigateway.filter.AuthorizationFilter.*;
//
//@Component
//public class AuthorizationFilter extends AbstractGatewayFilterFactory<Config> {
//
//    private final JwtTokenProperty jwtTokenProperty;
//
//    public static class Config {}
//
//    public AuthorizationFilter(JwtTokenProperty jwtTokenProperty) {
//        super(Config.class);
//        this.jwtTokenProperty = jwtTokenProperty;
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            HttpHeaders headers = exchange.getRequest().getHeaders();
//            validateAuthorizationHeader(headers);
//            String jwt = generateJwt(headers);
//            validateBearer(jwt);
//            validationJwt(jwt);
//            return chain.filter(exchange);
//        };
//    }
//
//    private String generateJwt(HttpHeaders headers) {
//        List<String> authorizations = headers.get(HttpHeaders.AUTHORIZATION);
//        String authorizationHeader = Objects.requireNonNull(authorizations).get(0);
//        return authorizationHeader.replace("Bearer", "");
//    }
//
//    private void validateAuthorizationHeader(HttpHeaders header) {
//        if (!header.containsKey(HttpHeaders.AUTHORIZATION)) {
//            throw new JudoManagerGatewayException(AUTHORIZATION_HEADER_NOT_FOUND);
//        }
//    }
//
//    private void validateBearer(String jwt) {
//        if (!jwt.startsWith("Bearer")) {
//            throw new JudoManagerGatewayException(BEARER_NOT_FOUND);
//        }
//    }
//
//    private void validationJwt(String jwt) {
//        try {
//            String subject = Jwts.parser()
//                    .setSigningKey(jwtTokenProperty.getSecret())
//                    .parseClaimsJws(jwt)
//                    .getBody()
//                    .getSubject();
//            if (subject == null || subject.isEmpty()) {
//                throw new JudoManagerGatewayException(EMPTY_TOKEN);
//            }
//        } catch (Exception ex) {
//            throw new JudoManagerGatewayException(INVALID_TOKEN);
//        }
//    }
//}
