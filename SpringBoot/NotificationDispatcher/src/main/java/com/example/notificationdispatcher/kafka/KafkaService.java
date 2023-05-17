package com.example.notificationdispatcher.kafka;

import com.example.notification.schema.SubscriptionAvro;
import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationdispatcher.Mapper;
import com.example.notificationdispatcher.SubscriptionRepository;
import com.example.notificationservice.model.Subscription;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class KafkaService {
    private SubscriptionRepository subscriptionRepository;
    private RedisTemplate redisTemplate;
    private Mapper mapper;

    KafkaService(SubscriptionRepository subscriptionRepository, RedisTemplate redisTemplate, Mapper mapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.redisTemplate = redisTemplate;
        this.mapper = mapper;
    }

    RestTemplate restTemplate = new RestTemplate();


    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);


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
            int retryCount = 0;
            boolean success = false;
            while (retryCount < 3 && !success) {
                try {
                    restTemplate.postForLocation(endpoint, test);
                    success = true;
                } catch (HttpServerErrorException | HttpClientErrorException e) {
                    LOGGER.warn("Error occurred while sending notification: " + e.getMessage());
                    retryCount++;
                    if (retryCount < 3) {
                        LOGGER.info("Retrying after 30 seconds...");
                        try {
                            Thread.sleep(30000); // Wait for 30 seconds before retrying
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
            if (!success) {
                LOGGER.error("Failed to send notification after maximum retries.");
            }
        }
    }
}

