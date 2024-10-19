package com.ghosttrio.judomanager.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerSearchApplication.class, args);
    }

}
