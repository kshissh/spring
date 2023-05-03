package com.example.notificationservice.DTO;

public class ViolationDTO {
    String field;
    String message;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ViolationDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
