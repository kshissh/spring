package com.example.subscriptionproject.api;

import com.example.subscriptionproject.SubscriptionServiceImpl;
import com.example.subscriptionproject.model.Subscription;
import com.example.subscriptionproject.notification.Notification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class NotificationController {
    private SubscriptionServiceImpl subscriptionService;
    NotificationController(SubscriptionServiceImpl subscriptionService) {
        this.subscriptionService = subscriptionService;
    }
    @PostMapping("/sendNotification/{subscriptionId}")
    public void sendNotification(@PathVariable("subscriptionId") UUID subscriptionId) {
        Subscription subscription = subscriptionService.getById(subscriptionId);
        if (subscription != null) {
            String endpoint = subscription.getTransport().getEndpoint();
            Notification notification = new Notification("Notification",subscription.getSubscriptionId());
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForLocation(endpoint, notification);
        }
    }
}
