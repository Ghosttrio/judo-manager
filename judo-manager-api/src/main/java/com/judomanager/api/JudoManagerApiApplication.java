package com.judomanager.api;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableFeignClients
@EnableScheduling
@EnableBatchProcessing
public class JudoManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerApiApplication.class, args);
    }

}
