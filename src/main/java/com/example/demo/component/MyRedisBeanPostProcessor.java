package com.example.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * 自定义redis关联Bean处理器
 *
 * @Author ZhanG_b1nG
 * @Date 2021/9/13 18:06
 * @Version 1.0
 **/
@Component
@Slf4j
public class MyRedisBeanPostProcessor implements BeanPostProcessor {
    /**
     * Bean的后置处理器来设置redis的序列化
     *
     * @param bean
     * @param beanName
     * @return java.lang.Object
     * @Author ZhanG_b1nG
     * @Date 2021/9/13 18:10
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RedisTemplate) {
            RedisTemplate redisTemplate = (RedisTemplate) bean;
            redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
            System.out.println("实现BeanPostProcessor，重写postProcessBeforeInitialization方法");
            return redisTemplate;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RedisTemplate) {
            System.out.println("实现BeanPostProcessor，重写postProcessAfterInitialization方法");
        }
        return bean;
    }
}
