package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Subscription;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


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
        Iterable<Subscription> iter = subscriptionRepo.findAll();
        List<Subscription> subscriptions = StreamSupport.stream(iter.spliterator(), false)
                .collect(Collectors.toList());
        return subscriptions;
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
        Subscription existingSubscription = subscriptionRepo.findById(subscriptionId).orElse(null);
        if (existingSubscription != null) {
            subscriptionRepo.deleteById(subscriptionId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The subscription was not found");
        }
    }

    @Override
    public Subscription getById(String subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepo.findById(subscriptionId);
        Subscription sub = subscription.orElse(null);
        if(sub!= null) {
            return sub;
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The subscription was not found");
    }

}

