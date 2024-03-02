package com.example.StudentManagementSystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CredentialsUpdateRequestDto {
    @JsonProperty
    private Integer credentialsID;
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;
    @JsonProperty
    private String username;
    @JsonProperty
    private Integer role;
}
