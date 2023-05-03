package com.example.notificationservicetool;

import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationservicetool.kafka.KafkaProducer;
import com.example.notificationservicetool.model.Notification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NotificationController {
    private KafkaProducer kafkaProducer;

    NotificationController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/sendMessage")
    public void createNotification(Notification message) {
        kafkaProducer.sendMessage(message);
    }
}
