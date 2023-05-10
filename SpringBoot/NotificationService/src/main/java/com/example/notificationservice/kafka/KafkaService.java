package com.example.notificationservice.kafka;

import com.example.notification.schema.SubscriptionAvro;
import com.example.notificationservice.Mapper;
import com.example.notificationservice.model.Subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
    private KafkaTemplate<String, SubscriptionAvro> kafkaTemplate;
    private Mapper mapper;

    public KafkaService(KafkaTemplate<String, SubscriptionAvro> kafkaTemplate, Mapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public void sendMessage(Subscription subscription){
        SubscriptionAvro message = mapper.toAvro(subscription);
        kafkaTemplate.send("notification-subscription","Subscription", message);
        LOGGER.info(String.format("Message sent %s", message));
    }

}
