package com.example.subscriptionproject.notification;

import com.example.subscriptionproject.SubscriptionRepository;
import com.example.subscriptionproject.model.Subscription;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NotificationService {

    public SubscriptionRepository subscriptionRepository;

    NotificationService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }
    RestTemplate restTemplate = new RestTemplate();
    public void sendNotifications() {
        Iterable<Subscription> iter = subscriptionRepository.findAll();
        List<Subscription> subscriptions = StreamSupport.stream(iter.spliterator(), false)
                .collect(Collectors.toList());
        for (Subscription sub : subscriptions) {
            String endpoint = sub.getTransport().getEndpoint();
            Notification notification = new Notification("Notification", UUID.randomUUID().toString());
            restTemplate.postForLocation(endpoint,notification);
        }
    }
}
