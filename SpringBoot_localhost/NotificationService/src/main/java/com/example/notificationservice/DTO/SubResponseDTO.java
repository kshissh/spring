package com.example.notificationservice.DTO;


import java.time.LocalDateTime;

public class SubResponseDTO {
    private String subscriptionId;
    private String createdAt;
    private String expiresAt;

    private String status;
    private String family;
    private TransportDTO transport;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
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

    public SubResponseDTO(String subscriptionId, String createdAt, String expiresAt, String status, String family, TransportDTO transport) {
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
