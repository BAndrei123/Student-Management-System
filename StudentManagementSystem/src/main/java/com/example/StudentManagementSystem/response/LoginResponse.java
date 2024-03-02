package com.example.StudentManagementSystem.response;

public class LoginResponse {
    Integer id;

    Integer role;
    String message;
    Boolean response;

    public LoginResponse(Integer id, Integer role, String message, Boolean response) {
        this.id = id;
        this.role = role;
        this.message = message;
        this.response = response;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
        return "LoginResponse{" +
                "id=" + id +
                ", role=" + role +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}
