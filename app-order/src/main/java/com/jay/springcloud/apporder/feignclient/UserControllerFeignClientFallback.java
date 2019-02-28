package com.jay.springcloud.apporder.feignclient;

import org.springframework.stereotype.Component;

@Component
public class UserControllerFeignClientFallback implements UserControllerFeignClient {
    @Override
    public String findById(String userId) {
        return "fallback";
    }
}
