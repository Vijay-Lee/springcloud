package com.jay.springcloud.apporder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppOrderApplication.class, args);
	}

}
