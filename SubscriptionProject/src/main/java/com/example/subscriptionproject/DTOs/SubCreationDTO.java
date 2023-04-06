package com.example.subscriptionproject.DTOs;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

public class SubCreationDTO {
    @NotNull(message = "There shouldn't be null")
    private String family;

    private TransportDTO transport;

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

    @AssertTrue(message = "Transport type must be WEBHOOK")
    public boolean isTransport() {
        if (transport == null || !"WEBHOOK".equals(transport.getType())) {
            return false;
        }
        return true;
    }

    @AssertTrue(message = "If transport type is WEBHOOK, then there must be \"endpoint\"")
    public boolean isEndpoint() {
        if (transport.getEndpoint() == null) {
            return false;
        }
        return true;
    }
}
