package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * wemvc扩展配置，继承WebMvcConfigurerAdapter会进行springmvc扩展
 * EnableWebMvc注解会导致springboot自动配置springmvc失效，如静态页面访问不了
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/10 10:51
 * @Version 1.0
 **/
@Configuration
//@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }
}
