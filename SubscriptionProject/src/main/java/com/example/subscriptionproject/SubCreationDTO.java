package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Transport;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SubCreationDTO {
    private UUID subscriptionId;
    private Date createdAt;
    private Date expiresAt;

    private String status;
    private final String family = "CALL_RECORDING";
    private List<Transport> transport;

    public UUID getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(UUID subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
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

    public List<Transport> getTransport() {
        return transport;
    }

    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }
}
