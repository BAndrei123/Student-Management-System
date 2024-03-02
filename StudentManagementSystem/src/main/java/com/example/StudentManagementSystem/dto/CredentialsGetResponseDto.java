package com.example.StudentManagementSystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CredentialsGetResponseDto {
    private Integer credentialsID;

    private String email;

    private String password;

    private String username;

    private Integer role;
}
