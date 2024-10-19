package com.judomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerAdminApplication.class, args);
    }

}
