package com.example.demo.Intercepters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义intercepter
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/8 21:40
 * @Version 1.0
 **/
@Configuration
public class MyIntercepter implements WebMvcConfigurer {
    @Autowired
    private HelloWorldIntercepter helloWorldIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(helloWorldIntercepter).addPathPatterns("/intercepter/**");
    }
}
