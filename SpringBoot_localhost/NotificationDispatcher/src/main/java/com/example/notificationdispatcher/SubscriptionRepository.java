package com.example.notificationdispatcher;

import com.example.notificationservice.model.Subscription;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriptionRepository {
    private RedisTemplate redisTemplate;

    public SubscriptionRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public List<Subscription> findAll(){
        return redisTemplate.opsForHash().values("Sub");
    }
}
