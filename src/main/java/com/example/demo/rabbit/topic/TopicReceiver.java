package com.example.demo.rabbit.topic;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * 通配符接收者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 10:26
 * @Version 1.0
 **/
@Slf4j
public class TopicReceiver {

    @RabbitListener(queues = "#{anonymousQueue1.name}")
    public void receive1(String in) {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{anonymousQueue2.name}")
    public void receive2(String in) {
        receive(in, 2);
    }

    private void receive(String in, int receiver) {
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance {} [x] Received '{}'", receiver, in);
        doWork(in);
        watch.stop();
        log.info("instance {} [x] Done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }
}
