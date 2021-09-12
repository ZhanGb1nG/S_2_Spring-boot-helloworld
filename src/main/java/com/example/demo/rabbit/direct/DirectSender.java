package com.example.demo.rabbit.direct;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 路由模式生产者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 14:50
 * @Version 1.0
 **/
@Slf4j
public class DirectSender {
    private final String[] keys = {"orange", "black", "green"};

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(int index) {
        StringBuilder builder = new StringBuilder("Hello to ");
        int limitIndex = index % 3;
        String key = keys[limitIndex];
        builder.append(key).append(' ');
        builder.append(index + 1);
        String message = builder.toString();
        UUID uuid = UUID.randomUUID();
        rabbitTemplate.convertAndSend(DirectConfig.DIRECT_EXCHANGE_HELLO, key, message, new CorrelationData(uuid.toString()));
        log.info(" [x] Sent '{}', uuid: {}", message, uuid.toString());
    }

}
