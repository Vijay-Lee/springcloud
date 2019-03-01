package com.jay.springcloud.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class InfraGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfraGatewayApplication.class, args);
	}
}
