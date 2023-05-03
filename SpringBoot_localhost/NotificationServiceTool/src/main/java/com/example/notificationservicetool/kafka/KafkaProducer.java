package com.example.notificationservicetool.kafka;

import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationservicetool.Mapper;
import com.example.notificationservicetool.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private Mapper mapper;
    private KafkaTemplate<String, String> kafkaTemplate; //there should be NotificationAvro as a value

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, Mapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    public void sendMessage(Notification notification){
        notification.setEvent("Notification");
        notification.setId(UUID.randomUUID().toString());
        NotificationAvro notificationAvro = mapper.toAvro(notification);
        kafkaTemplate.send("engagement-topic", notificationAvro.toString());
        LOGGER.info(String.format("Message sent %s", notification));
    }
}
