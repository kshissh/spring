package com.example.notificationdispatcher.kafka;

import com.example.notificationdispatcher.SubscriptionRepository;
import com.example.notificationservice.model.Subscription;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class KafkaService {
    private SubscriptionRepository subscriptionRepository;
    private RedisTemplate redisTemplate;

    KafkaService(SubscriptionRepository subscriptionRepository, RedisTemplate redisTemplate) {
        this.subscriptionRepository = subscriptionRepository;
        this.redisTemplate = redisTemplate;
    }
    RestTemplate restTemplate = new RestTemplate();

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);


    @KafkaListener(topics = "notification-subscription", groupId = "myGroup")
    public void consume(ConsumerRecord<String, String> message) {
        LOGGER.info(String.format("Message received -> %s", message));
    }
    @Async("threadPoolTaskExecutor")
   @KafkaListener(topics = "engagement-topic", groupId = "myGroup")
    public void sendNotification(ConsumerRecord<String, String> message) {
        LOGGER.info(String.format("Message received -> %s", message));
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        for (Subscription sub : subscriptions) {
            String endpoint = sub.getTransport().getEndpoint();
            restTemplate.postForLocation(endpoint,message.value());
        }
        System.out.println("Execute method with configured executor - "
                + Thread.currentThread().getName());
    }
}
