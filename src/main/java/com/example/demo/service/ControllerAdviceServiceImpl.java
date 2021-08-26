package com.example.demo.service;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * SpringMVC 中 @ControllerAdvice 注解的三种使用场景
 * 全局异常处理
 * 全局数据绑定
 * 全局数据预处理
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/26 8:43
 * @Version 1.0
 **/
@ControllerAdvice
public class ControllerAdviceServiceImpl {

    /**
     * 全局数据绑定
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @Author ZhanG_b1nG
     * @Date 2021/8/26 9:24
     */
    @ModelAttribute(name = "prices")
    public Map<String, Object> setPrice() {
        Map<String, Object> map = new HashMap<>();
        map.put("price", 1000);
        return map;
    }

    @InitBinder("b")
    public void b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }

    @InitBinder("a")
    public void a(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }
}
