package com.jay.springcloud.apporder.controller;

import com.jay.springcloud.apporder.feignclient.UserControllerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 李文杰 on 2019/2/20
 * 功能：
 */
@RestController
@RequestMapping("/order")
@EnableCircuitBreaker//@EnableHystrix

public class HelloController {
    //定义一个map模拟存表
    private static Map USER_MAP = new ConcurrentHashMap();
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Order:" + new Date();
    }

    //模拟一个服务调用，在order系统调用user服务
    @Autowired
    RestTemplate restTemplate;

    //注入声明式接口，通过feign调用服务
    @Autowired
    UserControllerFeignClient userControllerFeignClient;


    @RequestMapping("/add")
    //调用失败默认方法
    //@HystrixCommand(fallbackMethod = "addFallback")
    public String add(String userId,String orderId,String orderName){
        //request对象
        MultiValueMap<String,String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("userId",userId);
        //方式1.通过IP地址调用 用户服务获取到用户名 通过ip获取（实际不推荐，此处用于演示）
        //String userName = restTemplate.postForObject("http://localhost:9091/user/findById",requestEntity,String.class);

        //方式2;通过服务名调用，通过改端口部署多个user 服务，用于演示Rest+Ribbon实现负载均衡
        //eureka已默认集成ribbon，不用额外导包
        //String userName = restTemplate.postForObject("http://app-user/user/findById",requestEntity,String.class);

        //方式3:通过Feign调用,feign默认集成了Ribbon，即支持客户端负载均衡
        String userName = userControllerFeignClient.findById(userId);
        USER_MAP.put(orderId,orderName);
        orderName = userName + " 的订单： " +  orderName;
        return userId + ":" + orderName + "--"+UUID.randomUUID().toString();
    }

    public String addFallback(String userId,String orderId,String orderName){
        return "addUser调用失败！";
    }
}
