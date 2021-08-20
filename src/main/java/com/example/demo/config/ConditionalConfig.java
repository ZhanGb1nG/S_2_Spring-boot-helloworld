package com.example.demo.config;

import com.example.demo.component.TulingAspect;
import com.example.demo.component.TulingConditional;
import com.example.demo.component.TulingLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ZhanG_b1nG
 * @Date 2021/8/20 15:27
 * @Version 1.0
 **/
@Configuration
public class ConditionalConfig {
    @Bean
    public TulingAspect tulingAspect() {
        System.out.println("TulingAspect组件自动装配到容器中");
        return new TulingAspect();
    }

    @Bean
    @Conditional(value = TulingConditional.class)
    public TulingLog tulingLog() {
        System.out.println("TulingLog组件自动装配到容器中");
        return new TulingLog();
    }
}
