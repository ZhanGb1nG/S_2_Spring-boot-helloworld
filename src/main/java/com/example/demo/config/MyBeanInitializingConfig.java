package com.example.demo.config;

import com.example.demo.component.MyInitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/9/13 22:02
 * @Version 1.0
 **/
@Configuration
public class MyBeanInitializingConfig {
    /**
     * 自定义初始化init方法
     *
     * @param
     * @return com.example.demo.component.MyInitializingBean
     * @Author ZhanG_b1nG
     * @Date 2021/9/13 22:03
     */
    @Bean(initMethod = "init")
    public MyInitializingBean myInitializingBean() {
        return new MyInitializingBean();
    }
}
