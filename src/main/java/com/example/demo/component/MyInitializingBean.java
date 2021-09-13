package com.example.demo.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/9/13 21:58
 * @Version 1.0
 **/
public class MyInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("com.example.demo.component.MyInitializingBean.afterPropertiesSet");
    }

    public MyInitializingBean() {
        System.out.println("com.example.demo.component.MyInitializingBean.MyInitializingBean");
    }

    public void init() {
        System.out.println("com.example.demo.component.MyInitializingBean.init");
    }
}
