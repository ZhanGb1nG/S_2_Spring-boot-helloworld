package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * redis配置类
 *
 * @Author ZhanG_b1nG
 * @Date 2021/8/19 19:53
 * @Version 1.0
 **/
@Configuration
public class RedisConfig {
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
}
