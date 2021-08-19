package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis整合测试类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/19 18:19
 * @Version 1.0
 **/
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test/redis/add")
    public String testRedis() {
        redisTemplate.opsForSet().add("username", "张三");

        return "redis";
    }
}
