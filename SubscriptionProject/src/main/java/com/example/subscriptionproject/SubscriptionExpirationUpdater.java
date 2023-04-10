package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Subscription;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class SubscriptionExpirationUpdater {

    private SubscriptionRepository subscriptionRepo;

    SubscriptionExpirationUpdater(SubscriptionRepository subscriptionRepo) {
        this.subscriptionRepo = subscriptionRepo;
    }


    @Scheduled(initialDelay = 1000L,fixedDelay = 3000L)
    public void checkExpiredSubscriptions() {
        Iterable<Subscription> iter = subscriptionRepo.findAll();
        List<Subscription> subscriptions = StreamSupport.stream(iter.spliterator(), false)
                .collect(Collectors.toList());
        for (Subscription subscription : subscriptions) {
            if (LocalDateTime.now().isAfter(subscription.getExpiresAt())) {
                subscription.setStatus("SUSPENDED");
                subscriptionRepo.save(subscription);
            }
        }
    }
}
