package com.jay.springcloud.appuser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 李文杰 on 2019/2/20
 * 功能：
 */
@RestController
@RequestMapping("/user")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello User:" + new Date();
    }
}
