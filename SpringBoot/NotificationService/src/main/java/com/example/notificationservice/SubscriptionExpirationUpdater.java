package com.example.notificationservice;

import com.example.notificationservice.model.Subscription;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;



@Component
public class SubscriptionExpirationUpdater {

   private SubscriptionRepository subscriptionRepo;

    public SubscriptionExpirationUpdater(SubscriptionRepository subscriptionRepo) {
        this.subscriptionRepo = subscriptionRepo;
    }

    @Scheduled(fixedRate = 3000)
    public void checkExpiredSubscriptions() {
        List<Subscription> subscriptions = subscriptionRepo.findAll();
        for (Subscription subscription : subscriptions) {
            String expiresAtStr = subscription.getExpiresAt();
            LocalDateTime expiresAt = LocalDateTime.parse(expiresAtStr);
            if (LocalDateTime.now().isAfter(expiresAt)){
                subscription.setStatus("SUSPENDED");
                subscriptionRepo.save(subscription);
            }
        }
    }
}