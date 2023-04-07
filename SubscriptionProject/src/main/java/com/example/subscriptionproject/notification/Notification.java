package com.example.subscriptionproject.notification;


public class Notification {
    private String event;
    private String id;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Notification(String event, String id) {
        this.event = event;
        this.id = id;
    }
    public Notification() {}
}
