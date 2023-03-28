package com.example.subscriptionproject.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(schema = "subscription")
public class Subscription {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
    private UUID subscriptionId;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "expiresAt")
    private Date expiresAt;

    @Column(name = "status")
    private String status;
    @Column(name = "family")
    private final String family = "CALL_RECORDING";
    @OneToMany
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

    public Subscription() {

    }

    public List<Transport> getTransport() {
        return transport;
    }

    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }
}
