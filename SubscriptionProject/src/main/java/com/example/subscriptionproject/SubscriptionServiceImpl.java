package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Subscription;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepo;

    SubscriptionServiceImpl(SubscriptionRepository subscriptionRepo) {
    this.subscriptionRepo = subscriptionRepo;
    }


    @Override
    public Subscription create(Subscription subscription) {
        subscription.setSubscriptionId(UUID.randomUUID());
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setExpiresAt(LocalDateTime.now().plusHours(1));
        subscription.setStatus("ACTIVE");
        return subscriptionRepo.save(subscription);
    }
    @Override
    public List<Subscription> getAll() {
        return subscriptionRepo.findAll();
    }
    @Override
    public Subscription updateSubscription(UUID subscriptionId) {
        Subscription existingSubscription = subscriptionRepo.findById(subscriptionId).orElse(null);
        if (existingSubscription != null) {
            existingSubscription.setCreatedAt(LocalDateTime.now());
            existingSubscription.setExpiresAt(LocalDateTime.now().plusHours(1));
            existingSubscription.setStatus("ACTIVE");
            return subscriptionRepo.save(existingSubscription);
        }
        return null;
    }

    @Override
    public void delete(UUID subscriptionId) {
        subscriptionRepo.deleteById(subscriptionId);
    }

    @Override
    public Subscription getById(UUID subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepo.findById(subscriptionId);
        Subscription sub = subscription.orElse(null);
        return sub;
    }

}
