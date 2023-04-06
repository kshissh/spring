package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Subscription;
import org.hibernate.ObjectNotFoundException;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {
    Subscription create(Subscription subscription);
    List<Subscription> getAll();
    Subscription updateSubscription(String subscriptionId);
    void delete(String subscriptionId);
    Subscription getById(String subscriptionId) throws ObjectNotFoundException;

    }

