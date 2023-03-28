package com.example.subscriptionproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transport {
    private String type;
    private Object endpoint;
   @Id
   @GeneratedValue

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Object endpoint) {
        this.endpoint = endpoint;
    }

    public Transport(String type, Object endpoint) {
        this.type = type;
        this.endpoint = endpoint;
    }
    public Transport() {

    }
}
