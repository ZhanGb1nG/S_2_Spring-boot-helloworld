package com.example.demo.rabbit.simple;

import com.example.demo.rabbit.simple.SimpleReceiver;
import com.example.demo.rabbit.simple.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbit简单模式配置
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/3 11:13
 * @Version 1.0
 **/
@Configuration
public class RabbitSimpleConfig {

    @Bean
    public Queue simpleQueue() {
        return new Queue(SimpleSender.SIMPLE_QUEUQ_HELLO);
    }

    @Bean
    public SimpleSender simpleSender() {
        return new SimpleSender();
    }

    @Bean
    public SimpleReceiver simpleReceiver() {
        return new SimpleReceiver();
    }

}
