package com.ghosttrio.judomanager.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JudoManagerUserApplication.class, args);
	}

}
