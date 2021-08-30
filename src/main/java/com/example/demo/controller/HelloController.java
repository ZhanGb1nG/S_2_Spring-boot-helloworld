package com.example.demo.controller;

import com.example.demo.Exceptions.MyException;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.config.PersonConfig;
import com.example.demo.pojo.GirlFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * helloWorld2.2
 *
 * @Author ZhanG_b1nG
 * @Date 2020/4/7 22:16
 * @Version 1.0
 **/
@RestController
public class HelloController {
    /**
     * helloword测试
     * http://localhost:8080/zhangbingbing/hello
     * 
     * @param 
     * @return java.lang.String
     * @Author ZhanG_b1nG 
     * @Date 2021/8/30 22:57
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring boot!";
    }

    /**
     * 拦截器测试
     * http://localhost:8080/zhangbingbing/intercepter/hello
     *
     * @param
     * @return java.util.Map
     * @Author ZhanG_b1nG
     * @Date 2021/8/30 22:58
     */
    @RequestMapping("/intercepter/hello")
    public Map hello2() {
        System.out.println("com.example.demo.controller.HelloController.hello2");
        Map map = new HashMap<>(8);
        map.put("user", "lisi");

        return map;
    }

    @Autowired
    private PersonConfig person;

    /**
     * PersonConfig配置文件读取测试
     * http://localhost:8080/zhangbingbing/person
     *
     * @param
     * @return java.lang.Object
     * @Author ZhanG_b1nG
     * @Date 2021/8/30 22:58
     */
    @RequestMapping("/person")
    public Object getPerson() {
        System.out.println("person:" + person.toString());
        return person.toString();
    }

    /**
     * 异常跳转测试
     * http://localhost:8080/zhangbingbing/test/error
     *
     * @param 
     * @return java.lang.String
     * @Author ZhanG_b1nG 
     * @Date 2021/8/30 22:59
     */
    @RequestMapping("/test/error")
    public String textError() {
        throw new MyException(100, "异常测试");
    }

    /**
     * 自定义异常测试
     * http://localhost:8080/zhangbingbing/test/user
     *
     * @param username
     * @return java.lang.String
     * @Author ZhanG_b1nG 
     * @Date 2021/8/30 22:59
     */
    @RequestMapping("/test/user")
    public String getUser(@RequestParam("user") String username) {
        if (!username.equalsIgnoreCase("zhangsan")) {
            throw new UserNotFoundException();
        }
        return "hello zhangsan";
    }

    /**
     * ControllerAdvice注解全局数据绑定测试
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
     * ControllerAdvice注解数据预处理测试
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 测试druid数据源数据1
     * http://localhost:8080/zhangbingbing/test/jdbc
     * 
     * @param 
     * @return void
     * @Author ZhanG_b1nG 
     * @Date 2021/8/30 22:53
     */
    @RequestMapping("/test/jdbc")
    public void testJdbc() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from ums_role");
        System.out.println(maps.toString());
    }
}
