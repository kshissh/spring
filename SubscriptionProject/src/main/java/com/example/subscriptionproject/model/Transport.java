package com.example.subscriptionproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transport {
    private String type;
    @Id
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

    public Transport(String type, String endpoint) {
        this.type = type;
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "type='" + type + '\'' +
                ", endpoint='" + endpoint + '\'' +
                '}';
    }

    public Transport() {

    }
}
