package com.example.subscriptionproject.notification;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationService {
    public Notification sendNotificationToClient(Notification notification){
        notification = new Notification("Notification", UUID.randomUUID());
        return notification;
    }
}
