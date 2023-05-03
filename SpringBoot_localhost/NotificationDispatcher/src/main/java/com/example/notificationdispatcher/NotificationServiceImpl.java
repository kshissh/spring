package com.example.notificationdispatcher;

import com.example.notificationservice.model.Subscription;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationServiceImpl implements NotificationService{
    private SubscriptionRepository subscriptionRepository;

    NotificationServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }


    @Override
    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }
}
