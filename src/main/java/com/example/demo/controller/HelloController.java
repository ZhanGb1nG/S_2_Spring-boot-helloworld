package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * helloWorld2.2
 * http://localhost:8080/zhangbingbing/hello
 *
 * @Author ZhanG_b1nG
 * @Date 2020/4/7 22:16
 * @Version 1.0
 **/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring boot!";
    }

    @RequestMapping("/intercepter/hello")
    public Map hello2() {
        System.out.println("com.example.demo.controller.HelloController.hello2");
        Map map = new HashMap<>(8);
        map.put("user", "lisi");

        return map;
    }
}
