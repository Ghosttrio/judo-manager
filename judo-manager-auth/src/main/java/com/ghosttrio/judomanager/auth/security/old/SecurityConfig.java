//package com.ghosttrio.judomanager.auth.security;
//
//import com.ghosttrio.judomanager.auth.application.service.AuthenticationLoader;
//import com.ghosttrio.judomanager.auth.security.jwt.JwtAuthenticationEntryPoint;
//import com.ghosttrio.judomanager.auth.security.jwt.JwtExceptionFilter;
//import com.ghosttrio.judomanager.auth.security.jwt.JwtFilter;
//import com.ghosttrio.judomanager.auth.security.security.jwt.JwtResolver;
//import com.ghosttrio.judomanager.auth.security.security.jwt.JwtValidator;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import java.util.List;
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//@Configuration
//public class SecurityConfig {
//
//    private final JwtValidator jwtValidator;
//    private final JwtResolver jwtResolver;
//    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    private final AuthenticationLoader authenticationLoader;
//    private final CorsConfigurationSource corsConfigurationSource;
//    private final List<String> allowUrls = List.of(
//            "/mock/**", "/api/v1/auth/login", "/test"
//    );
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .httpBasic(AbstractHttpConfigurer::disable)
//                .csrf(AbstractHttpConfigurer::disable)
//                .formLogin(AbstractHttpConfigurer::disable)
//                .logout(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.configurationSource(corsConfigurationSource))
//                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
//                .exceptionHandling(authenticationManager ->
//                        authenticationManager.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//                .sessionManagement(sessionManagement ->
//                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterBefore(new JwtFilter(jwtResolver, jwtValidator, authenticationLoader, allowUrls), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new JwtExceptionFilter(), JwtFilter.class)
//                .build();
//    }
//
//}
