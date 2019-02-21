package com.jay.springcloud.apporder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 李文杰 on 2019/2/20
 * 功能：
 */
@RestController
@RequestMapping("/order")
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Order:" + new Date();
    }
}
