package com.example.demo.rabbit.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 发布订阅模式发送者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 10:02
 * @Version 1.0
 **/
@Slf4j
public class TopicSender {
    public static final String TOPIC_EXCHANGE_HELLO = "topic.exchange.hello";

    private final String[] keys = {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int index) {
        StringBuilder builder = new StringBuilder("Hello to ");
        int limitIndex = index%keys.length;
        String key = keys[limitIndex];
        builder.append(key).append(' ');
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_HELLO, key, message);
        log.info(" [x] Sent '{}'",message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
