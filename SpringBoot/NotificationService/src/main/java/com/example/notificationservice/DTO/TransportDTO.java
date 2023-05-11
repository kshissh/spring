package com.example.notificationservice.DTO;

import java.util.Objects;

public class TransportDTO {
    private String type;
    private String endpoint;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public TransportDTO() {

    }

    public TransportDTO(String type, String endpoint) {
        this.type = Objects.requireNonNull(type);
        this.endpoint = Objects.requireNonNull(endpoint);
    }
}
