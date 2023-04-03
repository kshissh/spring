package com.example.notificationapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class NotificationController {
    private NotificationService notificationService;
    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @PostMapping("/sendnotification")
    public ResponseEntity<Notification> sendNotification() {
        notificationService.sendNotificationToClient();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
