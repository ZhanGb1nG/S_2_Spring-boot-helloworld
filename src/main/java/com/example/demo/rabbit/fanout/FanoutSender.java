package com.example.demo.rabbit.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 发布订阅模式生产者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 12:46
 * @Version 1.0
 **/
@Slf4j
public class FanoutSender {

    public static final String FANOUT_EXCHANGE_HELLO = "fanout.exchange.hello";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(int index) {
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index % 3 + 1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index + 1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(FANOUT_EXCHANGE_HELLO, "", message);
        log.info(" [x] Sent '{}'", message);
    }

}
