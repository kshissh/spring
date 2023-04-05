package com.example.subscriptionproject.notification;

import com.example.subscriptionproject.SubscriptionRepository;
import com.example.subscriptionproject.model.Subscription;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NotificationService {

    public SubscriptionRepository subscriptionRepository;

    NotificationService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }
    RestTemplate restTemplate = new RestTemplate();
    public void sendNotifications() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        for (Subscription sub : subscriptions) {
            String endpoint = sub.getTransport().getEndpoint();
            Notification notification = new Notification("Notification",sub.getSubscriptionId());
            restTemplate.postForLocation(endpoint,notification);
        }
    }
}
