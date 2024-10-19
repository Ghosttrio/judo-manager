package com.ghosttrio.judomanager.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerAuthApplication.class, args);
    }

}
