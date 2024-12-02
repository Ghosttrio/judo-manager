package com.ghostrio.judomanager.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JudoManagerApigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerApigatewayApplication.class, args);
    }

}
