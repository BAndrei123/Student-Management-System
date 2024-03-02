package com.example.StudentManagementSystem.dto;

public class CredentialsDTO {

    private Integer credentialsID;

    private String email;

    private String password;

    private String username;

    private Integer role;

    public CredentialsDTO(Integer credentialsID, String email, String password, String username, Integer role) {
        this.credentialsID = credentialsID;
        this.email = email;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public CredentialsDTO() {
    }

    public Integer getCredentialsID() {
        return credentialsID;
    }

    public void setCredentialsID(Integer credentialsID) {
        this.credentialsID = credentialsID;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CredentialsDTO{" +
                "credentialsID=" + credentialsID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
