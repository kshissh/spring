package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Transport;

import java.time.LocalDateTime;
import java.util.UUID;

public class SubResponseDTO {
    private UUID subscriptionId;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    private String status;
    private String family;
    private Transport transport;

    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(UUID subscriptionId) {
        this.subscriptionId = subscriptionId;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public SubResponseDTO(UUID subscriptionId, LocalDateTime createdAt, LocalDateTime expiresAt, String status, String family, Transport transport) {
        this.subscriptionId = subscriptionId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.status = status;
        this.family = family;
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "SubResponseDTO{" +
                "subscriptionId=" + subscriptionId +
                ", createdAt=" + createdAt +
                ", expiresAt=" + expiresAt +
                ", status=" + status +
                ", family='" + family + '\'' +
                ", transport=" + transport +
                '}';
    }
}
