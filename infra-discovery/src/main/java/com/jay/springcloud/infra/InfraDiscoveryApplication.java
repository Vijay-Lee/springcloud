package com.jay.springcloud.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InfraDiscoveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfraDiscoveryApplication.class, args);
	}
}
