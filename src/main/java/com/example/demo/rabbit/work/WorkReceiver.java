package com.example.demo.rabbit.work;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

/**
 * 工作模式消费者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/3 21:11
 * @Version 1.0
 **/
@Slf4j
@RabbitListener(queues = WorkSender.WORK_QUEUE)
public class WorkReceiver {
    private final int num;

    public WorkReceiver(int num) {
        this.num = num;
    }

    @RabbitHandler
    public void receive(String in) {
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance {} [x] Received '{}'", this.num, in);
        doWork(in);
        watch.stop();
        log.info("instance {} [x] Done {} {}s", this.num, in, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }

}
