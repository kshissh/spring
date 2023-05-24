package com.example.notificationdispatcher.kafka;

import com.example.notification.schema.SubscriptionAvro;
import com.example.notificationdispatcher.KafkaListenerContainerManager;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class NotificationSubscriptionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationSubscriptionListener.class);

    private KafkaListenerContainerManager kafkaListenerContainerManager;

    NotificationSubscriptionListener(KafkaListenerContainerManager kafkaListenerContainerManager) {
        this.kafkaListenerContainerManager = kafkaListenerContainerManager;
    }

    @Async("threadPoolTaskExecutor")
    @KafkaListener(topics = "notification-subscription", groupId = "myGroup")
    public void consume(ConsumerRecord<String, SubscriptionAvro> message) throws IOException {
        LOGGER.info(String.format("Message received -> %s", message));
        kafkaListenerContainerManager.startContainer();
    }
}



