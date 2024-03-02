package com.example.StudentManagementSystem.response;

public class RegistrationResponse {
    String message;
    Boolean response;

    public RegistrationResponse(String message, Boolean response) {
        this.message = message;
        this.response = response;
    }

    public RegistrationResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}
