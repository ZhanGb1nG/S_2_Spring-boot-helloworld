package com.example.demo.controller;

import com.example.demo.Exceptions.MyException;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private PersonConfig person;

    @RequestMapping("/person")
    public Object getPerson() {
        System.out.println("person:" + person.toString());
        return person.toString();
    }

    @RequestMapping("/test/error")
    public String textError() {
        throw new MyException(100, "异常测试");
    }

    @RequestMapping("/test/user")
    public String getUser(@RequestParam("user") String username) {
        if (!username.equalsIgnoreCase("zhangsan")) {
            throw new UserNotFoundException();
        }
        return "hello zhangsan";
    }
}
