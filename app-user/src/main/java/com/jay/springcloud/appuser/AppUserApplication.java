package com.jay.springcloud.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class AppUserApplication {

	@Autowired
	private DiscoveryClient discoveryClient;
	public static void main(String[] args) {
		SpringApplication.run(AppUserApplication.class, args);
	}

	//获取服务元数据Demo
	@RequestMapping("/app-user-meta")
	public List getAppUserMeta(){
		return this.discoveryClient.getInstances("app-user");
	}

	//在对应服务配置文件可自定义metadata：metadata-map
	@RequestMapping("/app-order-meta")
	public List getAppOrderMeta(){
		return this.discoveryClient.getInstances("app-order");
	}


}
