package com.example.subscriptionproject.DTOs;


import java.time.LocalDateTime;

public class SubResponseDTO {
    private String subscriptionId;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    private String status;
    private String family;
    private TransportDTO transport;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
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

    public TransportDTO getTransport() {
        return transport;
    }

    public void setTransport(TransportDTO transport) {
        this.transport = transport;
    }

    public SubResponseDTO(String subscriptionId, LocalDateTime createdAt, LocalDateTime expiresAt, String status, String family, TransportDTO transport) {
        this.subscriptionId = subscriptionId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.status = status;
        this.family = family;
        this.transport = transport;
    }

    public SubResponseDTO(String family, TransportDTO transport){
        this.family = family;
        this.transport = transport;
    }
    public SubResponseDTO(){}
}
