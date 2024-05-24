package com.judomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JudoManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerApiApplication.class, args);
    }

}
