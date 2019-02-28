package com.jay.springcloud.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*note
* Eureka server 自我保护机制
*
* 1.90秒未收到服务消息，将注册的服务删掉
* 禁用自我保护模式enable-self-preservation: false
*
* 2.多网卡环境下的IP选择
* 忽略指定名称的网卡spring.cloud.inetutils.ignored-interfaces
* 正则spring.cloud.inetutils.preferredNetworks:- 192.168 -10.0
* 只使用站点本地地址spring.cloud.inetutils.useOnlySiteLocallnterfaces:true
* 手动指定Ip eureka.instance.ip-address:127.0.0.1
*
* 3.Eureka的健康检查（默认是基于30秒心跳）
* 可配置Spring boot actuator，让服务将健康状态传播到Eureka Server上
* */



@SpringBootApplication
@EnableEurekaServer
public class InfraDiscoveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(InfraDiscoveryApplication.class, args);
	}
}
