package com.ghosttrio.judomanager.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {
    private static final String FRONT_LOCAL_ENV = "http://localhost:3000";

    private final List<String> allowedMethods = List.of("GET", "POST", "PUT", "DELETE", "PATCH");

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", defaultCorsConfig());
        return source;
    }

    private CorsConfiguration defaultCorsConfig() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(FRONT_LOCAL_ENV));
        configuration.setAllowedMethods(allowedMethods);
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        return configuration;
    }
}
