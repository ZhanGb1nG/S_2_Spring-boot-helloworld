package com.example.demo.controller;

import com.example.demo.Exceptions.MyException;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.config.PersonConfig;
import com.example.demo.pojo.GirlFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    /**
     * http://localhost:8080/zhangbingbing/test/prices
     *
     * @param model
     * @return java.lang.String
     * @Author ZhanG_b1nG
     * @Date 2021/8/26 16:14
     */
    @RequestMapping("/test/prices")
    public String getPrices(Model model) {
        Map<String, Object> map = model.asMap();
        Object prices = map.get("prices");
        return prices.toString();
    }

    /**
     * http://localhost:8080/zhangbingbing/test/users?a.name=mangpanpan&a.age=30&b.name=mapangpang&b.age=18
     *
     * @param girlFriendA
     * @param girlFriendB
     * @return void
     * @Author ZhanG_b1nG
     * @Date 2021/8/26 16:33
     */
    @RequestMapping("/test/users")
    public void getBooks(@ModelAttribute("a") GirlFriend girlFriendA, @ModelAttribute("b") GirlFriend girlFriendB) {
        System.out.println(girlFriendA);
        System.out.println(girlFriendB);
    }
}
