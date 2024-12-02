package com.ghosttrio.judomanager.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JudoManagerEurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(JudoManagerEurekaserverApplication.class, args);
    }

}
