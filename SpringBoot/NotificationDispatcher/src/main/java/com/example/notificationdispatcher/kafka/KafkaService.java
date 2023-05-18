package com.example.notificationdispatcher.kafka;

import com.example.notification.schema.SubscriptionAvro;
import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationdispatcher.Mapper;
import com.example.notificationdispatcher.SendTask;
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

import java.io.IOException;
import java.util.List;


@Service
public class KafkaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
    private SubscriptionRepository subscriptionRepository;
    private RedisTemplate redisTemplate;
    private Mapper mapper;

    KafkaService(SubscriptionRepository subscriptionRepository,
                 RedisTemplate redisTemplate,
                 Mapper mapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.redisTemplate = redisTemplate;
        this.mapper = mapper;
    }

    RestTemplate restTemplate = new RestTemplate();


    @KafkaListener(topics = "notification-subscription", groupId = "myGroup")
    public void consume(ConsumerRecord<String, SubscriptionAvro> message) {
        LOGGER.info(String.format("Message received -> %s", message));
    }

    @Async("threadPoolTaskExecutor")
    @KafkaListener(topics = "engagement-topic", groupId = "myGroup")
   // @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 30000))
    public void sendNotification(ConsumerRecord<String, NotificationAvro> message) throws IOException {
        LOGGER.info(String.format("Message received -> %s", message));
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        for (Subscription sub : subscriptions) {
            String endpoint = sub.getTransport().getEndpoint();
            String test = mapper.avroToJson(message.value());
            SendTask sendTask = new SendTask(restTemplate, endpoint, test, 0);
            sendTask.run();
        }
    }
}

