package com.example.subscriptionproject.DTOs;


public class SubCreationDTO {
    private String family;
    private TransportDTO transport; //there should be a DTO

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

}
