package com.example.demo.rabbit.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 简单模式消费者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/3 11:05
 * @Version 1.0
 **/
@RabbitListener(queues = SimpleSender.SIMPLE_QUEUQ_HELLO)
@Slf4j
public class SimpleReceiver {

    @RabbitHandler
    public void receive(String in) {
        log.info(" [x] Received '{}'", in);;
    }
}
