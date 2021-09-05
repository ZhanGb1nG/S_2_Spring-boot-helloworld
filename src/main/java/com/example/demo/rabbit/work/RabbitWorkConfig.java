package com.example.demo.rabbit.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbit工作模式配置类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/5 17:17
 * @Version 1.0
 **/
@Configuration
public class RabbitWorkConfig {

    @Bean
    public Queue queue() {
        return new Queue(WorkSender.WORK_QUEUE);
    }

    @Bean
    public WorkSender workSender() {
        return new WorkSender();
    }

    @Bean
    public WorkReceiver workReceiver1() {
        return new WorkReceiver(1);
    }

    @Bean
    public WorkReceiver workReceiver2() {
        return new WorkReceiver(2);
    }

}
