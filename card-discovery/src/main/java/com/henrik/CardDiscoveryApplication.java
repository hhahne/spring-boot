package com.henrik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CardDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardDiscoveryApplication.class, args);
	}
}
