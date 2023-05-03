package com.example.notificationservice;

import com.example.notificationservice.kafka.KafkaService;
import com.example.notificationservice.model.Subscription;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepo;
    private KafkaService kafkaService;

    SubscriptionServiceImpl(SubscriptionRepository subscriptionRepo, KafkaService kafkaService) {
    this.subscriptionRepo = subscriptionRepo;
    this.kafkaService =kafkaService;
    }

    @Override
    public Subscription create(Subscription subscription) {
        subscription.setSubscriptionId(UUID.randomUUID().toString());
        subscription.setCreatedAt(LocalDateTime.now().toString());
        subscription.setExpiresAt(LocalDateTime.now().plusHours(1).toString());
        subscription.setStatus("ACTIVE");
        kafkaService.sendMessage(subscription);
        return subscriptionRepo.save(subscription);
    }
    @Override
    public List<Subscription> getAll() {
        return subscriptionRepo.findAll();
    }
    @Override
    public Subscription updateSubscription(String subscriptionId) {
        Subscription existingSubscription = subscriptionRepo.findById(subscriptionId);
        if (existingSubscription != null) {
            existingSubscription.setCreatedAt(LocalDateTime.now().toString());
            existingSubscription.setExpiresAt(LocalDateTime.now().plusHours(1).toString());
            existingSubscription.setStatus("ACTIVE");
            return subscriptionRepo.save(existingSubscription);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The subscription was not found");
    }

    @Override
    public void delete(String subscriptionId) {
        Subscription existingSubscription = subscriptionRepo.findById(subscriptionId);
        if (existingSubscription != null) {
            subscriptionRepo.delete(subscriptionId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The subscription was not found");
        }
    }

    @Override
    public Subscription getById(String subscriptionId) {
        Subscription sub = subscriptionRepo.findById(subscriptionId);
        if(sub!= null) {
            return sub;
        } throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The subscription was not found");
    }

}

