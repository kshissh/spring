package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Subscription;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {
    Subscription create(Subscription subscription);
    List<Subscription> getAll();
    Subscription updateSubscription(UUID subscriptionId);
    void delete(UUID subscriptionId);
    Subscription getById(UUID subscriptionId);

    }

