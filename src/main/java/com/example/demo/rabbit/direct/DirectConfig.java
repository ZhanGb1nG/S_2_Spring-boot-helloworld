package com.example.demo.rabbit.direct;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 路由模式配置类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 14:55
 * @Version 1.0
 **/
@Configuration
public class DirectConfig {

    public static final String DIRECT_EXCHANGE_HELLO = "direct.exchange.hello";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_HELLO);
    }

    @Bean
    public Queue directQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue directQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding directBinding1(DirectExchange directExchange, Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("orange");
    }

    @Bean
    public Binding directBinding2(DirectExchange directExchange, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("black");
    }

    @Bean
    public Binding directBinding3(DirectExchange directExchange, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("green");
    }

    @Bean
    public DirectSender directSender() {
        return new DirectSender();
    }

    @Bean
    public DirectReceiver directReceiver() {
        return new DirectReceiver();
    }

}
