package com.judomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JudoManagerChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(JudoManagerChatApplication.class, args);
	}

}
