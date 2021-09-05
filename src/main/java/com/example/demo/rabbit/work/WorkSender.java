package com.example.demo.rabbit.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 工作模式
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/3 21:03
 * @Version 1.0
 **/
@Slf4j
public class WorkSender {

    public static final String WORK_QUEUE = "work.queue.hello";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(int index) {
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index % 3+1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append('.');
        }
        builder.append(index+1);
        String message = builder.toString();
        rabbitTemplate.convertAndSend(WORK_QUEUE, message);
        log.info(" [x] Sent '{}'", message);
    }

}
