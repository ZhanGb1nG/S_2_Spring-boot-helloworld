package com.example.demo.rabbit.direct;

import cn.hutool.core.thread.ThreadUtil;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.StopWatch;

import java.io.IOException;

/**
 * 路由模式消费者
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 14:53
 * @Version 1.0
 **/
@Slf4j
public class DirectReceiver {
    @Autowired
    private RedisTemplate redisTemplate;

//    @RabbitListener(queues = "#{directQueue1.name}")
//    public void receive1(String in) {
//        receive(in, 1);
//    }

    @RabbitListener(queues = "#{directQueue1.name}")
    public void receive3(Message message, Channel channel) throws IOException {
        String payload = (String) message.getPayload();
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        log.info("receive3 {}", msgId);
        // 	将CorrelationData的ID存入到redis中，在每次发送消息时，从redis中取此ID，如果ID不存在，表示此消息未消费则发送消息；ID存在，则不发送；
        if (redisTemplate.opsForHash().entries("direct_receive").containsKey(msgId)) {
            try {
                // 确认消息已消费
                log.info("消息已消费，msgId: {}", msgId);
                channel.basicAck(tag, false);
                return;
            } catch (Exception e) {
                // 异常场景返回响应，requeue：true重新放回队列消费；requeue：false抛弃此消息
                channel.basicNack(tag, false, true);
                e.printStackTrace();
            }
        }
        try {
            // 实现具体的业务逻辑
            // ...
            // 将msg存入到redis中，并确认已消费
            redisTemplate.opsForHash().put("direct_receive", msgId, "mydirect");
            channel.basicAck(tag, false);
            log.info("业务处理完成，msgId: {}", msgId);
        } catch (Exception e) {
            // 异常场景返回响应，requeue：true重新放回队列消费；requeue：false抛弃此消息
            channel.basicNack(tag, false, true);
            e.printStackTrace();
        }
    }

//    @RabbitListener(queues = "#{directQueue2.name}")
//    public void receive2(String in) {
//        receive(in, 2);
//    }

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
