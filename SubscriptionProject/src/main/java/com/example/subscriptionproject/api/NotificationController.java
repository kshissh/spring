package com.example.subscriptionproject.api;

import com.example.subscriptionproject.notification.Notification;
import com.example.subscriptionproject.notification.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class NotificationController {
    private NotificationService notificationService;
    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @PostMapping("/sendnotification")
    public ResponseEntity<Notification> sendNotification() {
        Notification notification = new Notification();
        RestTemplate restTemplate = new RestTemplate();
        List<String> endpoints = Arrays.asList(
                "https://webhook.site/3337c25a-7f4a-4b5a-8f14-fec98c7f5f41",
                "https://webhook.site/014484e6-a5a5-4eb9-9761-acb916450fcf"
        );
        for (String endpoint : endpoints) {
            notification = notificationService.sendNotificationToClient(notification);
            restTemplate.postForLocation(endpoint, notification);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
