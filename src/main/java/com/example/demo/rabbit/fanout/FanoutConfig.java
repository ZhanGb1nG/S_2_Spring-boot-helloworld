package com.example.demo.rabbit.fanout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布订阅模式配置类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 12:48
 * @Version 1.0
 **/
@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FanoutSender.FANOUT_EXCHANGE_HELLO);
    }

    @Bean
    public Queue fanoutQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue fanoutQueue2() {
        return new AnonymousQueue();
    }

    /**
     * 队列和交换机绑定，发布订阅模式不需要绑定routingKey，直接发送给每一个队列
     *
     * @param fanoutExchange
     * @param fanoutQueue1
     * @return org.springframework.amqp.core.Binding
     * @Author ZhanG_b1nG
     * @Date 2021/9/6 13:02
     */
    @Bean
    public Binding fanoutBinding1(FanoutExchange fanoutExchange, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding fanoutBinding2(FanoutExchange fanoutExchange, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    @Bean
    public FanoutSender fanoutSender() {
        return new FanoutSender();
    }

    @Bean
    public FanoutReceiver fanoutReceiver() {
        return new FanoutReceiver();
    }

}
