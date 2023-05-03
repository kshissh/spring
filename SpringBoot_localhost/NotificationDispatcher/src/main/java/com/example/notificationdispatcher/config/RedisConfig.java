package com.example.notificationdispatcher.config;

import com.example.notificationservice.model.Subscription;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Configuration
@EnableRedisRepositories
@Component
public class RedisConfig {


    public static void main(String[] args) throws Exception {
        Jedis jedis = new Jedis("redis://:a-very-complex-password-here@10.42.0.97:6379");
        System.out.println("Connected to Redis");
    }

  /*  JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration("localhost", 6379);

        return new JedisConnectionFactory(redisConfiguration);
    }

    RedisTemplate<String, Subscription> redisTemplate() {
        RedisTemplate<String,Subscription> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.afterPropertiesSet();
        return redisTemplate();
    } */
}
