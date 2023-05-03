package com.example.notificationdispatcher;

import com.example.notificationservice.model.Subscription;

import java.util.List;

public interface NotificationService {
    List<Subscription> getAll();
}
