package com.example.demo.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbit配置类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/7 10:47
 * @Version 1.0
 **/
@Configuration
@Slf4j
public class RabbitConfig {

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    /**
     * 注入RabbitTemplate，confirm和return方法可以在controller层引入rabbitTemplate调用时单独设置
     *
     * @param
     * @return org.springframework.amqp.rabbit.core.RabbitTemplate
     * @Author ZhanG_b1nG
     * @Date 2021/9/9 11:48
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        // 消息只要被 rabbitmq broker 接收到就会执行 confirmCallback，如果是 cluster 模式，需要所有 broker 接收到才会调用 confirmCallback
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
            // ack判断broker是否接受成功
            if (ack) {
                if (correlationData != null) {
                    // CorrelationData 对象内部只有一个 id 属性，用来表示当前消息唯一性。
                    System.out.println(correlationData.getId());
                    log.info("broker接收成功，ID：{}", correlationData.getId());
                }
            } else {
                if (correlationData != null) {
                    log.info("broker接收失败，ID：{}", correlationData.getId());
                    log.info("broker接收失败，cause：{}", cause);
                    // 若是重试次数大于三次仍然发送失败，可将此消息缓存，后续人工处理或者定时处理，也可以将该消息扔入死信队列处理。
//                if (correlationData instanceof com.Configuration.CorrelationData) {
//                    com.Configuration.CorrelationData messageCorrelationData = (com.Configuration.CorrelationData) correlationData;
//                    String exchange = messageCorrelationData.getExchange();
//                    Object message = messageCorrelationData.getMessage();
//                    String routingKey = messageCorrelationData.getRoutingKey();
//                    int retryCount = messageCorrelationData.getRetryCount();
//                    //重试次数+1
//                    ((com.Configuration.CorrelationData) correlationData).setRetryCount(retryCount + 1);
//                    rabbitTemplate.convertSendAndReceive(exchange, routingKey, message, correlationData);
//                }
                }
            }
        });
        //消息失败回调函数
        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText,
                                          String exchange, String routingKey) -> {
            log.info("发送失败，message：{}", message.getMessageProperties().getCorrelationId());
            System.err.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        });

        return rabbitTemplate;
    }

}
