package com.example.demo.Intercepters;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义helloworld Intercepter 1
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/8 21:44
 * @Version 1.0
 **/
@Component
public class HelloWorldIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("HelloWorldIntercepter.preHandle");
//        默认为false，将不再往下走，需要改成true
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("HelloWorldIntercepter.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("HelloWorldIntercepter.afterCompletion");
    }
}
