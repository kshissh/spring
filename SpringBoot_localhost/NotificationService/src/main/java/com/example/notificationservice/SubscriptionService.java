package com.example.notificationservice;

import com.example.notificationservice.model.Subscription;


import java.util.List;


public interface SubscriptionService {
    Subscription create(Subscription subscription);
    List<Subscription> getAll();
    Subscription updateSubscription(String subscriptionId);
    void delete(String subscriptionId);
    Subscription getById(String subscriptionId);

    }

