package com.ghosttrio.judomanager.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerConfigurationApplication.class, args);
    }

}
