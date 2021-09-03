package com.example.demo.rabbit.simple;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 简单模式生产者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/3 11:05
 * @Version 1.0
 **/
@Slf4j
public class SimpleSender {

    public static final String SIMPLE_QUEUQ_HELLO = "simple.queue.hello";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        log.info("rabbit.simple.SimpleSender.sendMessage start");
        String message = "Simple Sender: hello!";
        // routingKey为SIMPLE_QUEUQ
        rabbitTemplate.convertAndSend(SIMPLE_QUEUQ_HELLO, message);
        log.info(" [x] Sent '{}'", message);
    }
}
