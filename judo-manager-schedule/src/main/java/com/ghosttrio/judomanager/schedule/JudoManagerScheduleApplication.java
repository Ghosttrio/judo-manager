package com.ghosttrio.judomanager.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerScheduleApplication.class, args);
    }

}
