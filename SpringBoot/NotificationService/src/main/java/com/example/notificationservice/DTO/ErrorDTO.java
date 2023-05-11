package com.example.notificationservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class ErrorDTO {
    private String errorMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ViolationDTO> violations;

    public List<ViolationDTO> getViolations() {
        return violations;
    }

    public void setViolations(List<ViolationDTO> violations) {
        this.violations = violations;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorDTO(String errorMessage, List<ViolationDTO> violations) {
        this.errorMessage = errorMessage;
        this.violations = violations;
    }

    public ErrorDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
