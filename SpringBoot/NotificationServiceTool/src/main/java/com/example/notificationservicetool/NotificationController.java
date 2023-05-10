package com.example.notificationservicetool;

import com.example.notificationservicetool.kafka.KafkaService;
import com.example.notificationservicetool.model.Notification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NotificationController {
    private KafkaService kafkaProducer;

    NotificationController(KafkaService kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/sendMessage")
    public void createNotification(Notification message) {
        kafkaProducer.sendMessage(message);
    }
}
