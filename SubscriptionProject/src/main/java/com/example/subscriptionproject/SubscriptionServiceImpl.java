package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Subscription;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepo;

    SubscriptionServiceImpl(SubscriptionRepository subscriptionRepo) {
    this.subscriptionRepo = subscriptionRepo;
    }


    @Override
    public Subscription create(Subscription subscription) {
        subscription.setSubscriptionId(UUID.randomUUID().toString());
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
    public Subscription updateSubscription(String subscriptionId) {
        Subscription existingSubscription = subscriptionRepo.findById(subscriptionId).orElse(null);
        if (existingSubscription != null) {
            existingSubscription.setCreatedAt(LocalDateTime.now());
            existingSubscription.setExpiresAt(LocalDateTime.now().plusHours(1));
            existingSubscription.setStatus("ACTIVE");
            return subscriptionRepo.save(existingSubscription);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The subscription was not found");
    }
    @Override
    public void delete(String subscriptionId) {
        subscriptionRepo.deleteById(subscriptionId);
    }

    @Override
    public Subscription getById(String subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepo.findById(subscriptionId);
        Subscription sub = subscription.orElse(null);
        if(sub!= null) {
            return sub;
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The subscription was not found");
    }
    @Scheduled(initialDelay = 10000L,fixedDelay = 300000L)
    public void checkExpiredSubscriptions() {
        List<Subscription> subscriptions = subscriptionRepo.findAll();
        for (Subscription subscription : subscriptions) {
            if (subscription.getExpiresAt().isAfter(LocalDateTime.now())) {
                subscription.setStatus("SUSPENDED");
                subscriptionRepo.save(subscription);
            }
        }
    }
}

