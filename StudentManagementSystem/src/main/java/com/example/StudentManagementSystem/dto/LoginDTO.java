package com.example.StudentManagementSystem.dto;

public class LoginDTO {
    private String email;
    private String password;


    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginDTO() {
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
