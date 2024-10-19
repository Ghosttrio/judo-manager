package com.ghosttrio.judomanager.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerPaymentApplication.class, args);
    }

}
