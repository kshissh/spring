package com.example.subscriptionproject.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    private String subscriptionId;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "expiresAt")
    private LocalDateTime expiresAt;

    @Column(name = "status")
    private String status;
    @Column(name = "family")
    private String family;
    @OneToOne(cascade = CascadeType.MERGE)
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
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

    public Subscription(String subscriptionId, LocalDateTime createdAt, LocalDateTime expiresAt, String status, String family, Transport transport) {
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
