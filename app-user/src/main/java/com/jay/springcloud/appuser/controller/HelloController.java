package com.jay.springcloud.appuser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 李文杰 on 2019/2/20
 * 功能：
 */
@RestController
@RequestMapping("/user")
public class HelloController {
    //定义一个map模拟存表
    private static Map USER_MAP = new ConcurrentHashMap();

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello User:" + new Date();
    }

    @RequestMapping("/add")
    public String add(String userId,String userName){
        USER_MAP.put(userId,userName);
        //追加个随机数便于测试
        return userId + "-"+userName + "新增成功"+ UUID.randomUUID().toString();
    }

    @RequestMapping("/findById")
    public String findByPK(String userId){
        return (String) USER_MAP.get(userId) + "9191端口获取的";
    }
}
