package com.example.notificationapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class NotificationService {
    private static final String WEBHOOK_URL = "https://webhook.site/3337c25a-7f4a-4b5a-8f14-fec98c7f5f41";
    public void sendNotificationToClient() {
        Notification notification = new Notification("Notification", UUID.randomUUID());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(WEBHOOK_URL, notification);
    }
}
