package com.ghosttrio.judomanager.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerNoticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerNoticeApplication.class, args);
    }

}
