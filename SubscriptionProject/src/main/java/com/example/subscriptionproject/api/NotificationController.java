package com.example.subscriptionproject.api;

import com.example.subscriptionproject.notification.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class NotificationController {
     private NotificationService notificationService;
    NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping("/sendNotification")
    public void sendNotification() {
        notificationService.sendNotifications();
    }
}


