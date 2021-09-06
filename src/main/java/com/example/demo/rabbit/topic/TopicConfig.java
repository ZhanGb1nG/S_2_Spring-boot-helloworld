package com.example.demo.rabbit.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.Topic;

/**
 * 通配符模式配置类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/6 10:35
 * @Version 1.0
 **/
@Configuration
public class TopicConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TopicSender.TOPIC_EXCHANGE_HELLO);
    }

    /**
     * AnonymousQueue类型的队列，它的名字是由客户端生成的，而且是非持久的，独占的，自动删除的队列
     *
     * @param
     * @return org.springframework.amqp.core.Queue
     * @Author ZhanG_b1nG
     * @Date 2021/9/6 10:39
     */
    @Bean
    public Queue anonymousQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue anonymousQueue2() {
        return new AnonymousQueue();
    }

    /**
     * 队列和交换机绑定
     * 这种关系可以读作：这个队列对这个交换器里的消息感兴趣。
     * 虽然 Queue类型有多个实例，但spring会自动更加名字匹配，bean名字匹配参数名字
     *
     * @param topicExchange
     * @param anonymousQueue1
     * @return org.springframework.amqp.core.Binding
     * @Author ZhanG_b1nG
     * @Date 2021/9/6 10:51
     */
    @Bean
    public Binding binding1A(TopicExchange topicExchange, Queue anonymousQueue1) {
        return BindingBuilder.bind(anonymousQueue1).to(topicExchange).with("*.orange.*");
    }

    @Bean
    public Binding binding1B(TopicExchange topicExchange, Queue anonymousQueue1) {
        return BindingBuilder.bind(anonymousQueue1).to(topicExchange).with("*.*.rabbit");
    }

    @Bean
    public Binding binding2(TopicExchange topicExchange, Queue anonymousQueue2) {
        return BindingBuilder.bind(anonymousQueue2).to(topicExchange).with("lazy.#");
    }

    @Bean
    public TopicSender topicSender() {
        return new TopicSender();
    }

    @Bean
    public TopicReceiver topicReceiver() {
        return new TopicReceiver();
    }

}
