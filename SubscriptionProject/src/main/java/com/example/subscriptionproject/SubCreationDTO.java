package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Transport;


public class SubCreationDTO {
    private String family;
    private Transport transport;

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
}
