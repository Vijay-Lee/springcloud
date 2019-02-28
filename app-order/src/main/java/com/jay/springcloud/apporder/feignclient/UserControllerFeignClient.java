package com.jay.springcloud.apporder.feignclient;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//声明式接口，通过feign调用user服务,指定调用失败实现类
@Component
@FeignClient(value = "app-user",fallback = UserControllerFeignClientFallback.class)
public interface UserControllerFeignClient {

    @RequestMapping("/user/findById")
    String findById(@RequestParam("userId") String userId);
}
