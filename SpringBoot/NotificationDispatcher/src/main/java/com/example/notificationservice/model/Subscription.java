package com.example.notificationservice.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


public class Subscription implements Serializable {

    private String subscriptionId;
    private String createdAt;
    private String expiresAt;
    private String status;
    private String family;
    private Transport transport;


    public Transport getTransport() {
        return transport;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getFamily() {
        return family;
    }

    public Subscription() {

    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Subscription(String family, Transport transport) {
        this.family = family;
        this.transport = transport;
    }

    public Subscription(String subscriptionId, String createdAt, String expiresAt, String status, String family, Transport transport) {
        this.subscriptionId = subscriptionId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.status = status;
        this.family = family;
        this.transport = transport;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId=" + subscriptionId +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", status=" + status +
                ", family='" + family + '\'' +
                ", transport=" + transport +
                '}';
    }
}
