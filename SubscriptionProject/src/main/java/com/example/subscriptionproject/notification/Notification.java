package com.example.subscriptionproject.notification;

import java.util.UUID;

public class Notification {
    private String event;
    private UUID id;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Notification(String event, UUID id) {
        this.event = event;
        this.id = id;
    }
    public Notification() {}
}
