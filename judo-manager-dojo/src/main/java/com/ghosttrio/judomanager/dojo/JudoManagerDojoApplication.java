package com.ghosttrio.judomanager.dojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerDojoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerDojoApplication.class, args);
    }

}
