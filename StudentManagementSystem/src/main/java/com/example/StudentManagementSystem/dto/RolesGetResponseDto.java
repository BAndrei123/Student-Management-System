package com.example.StudentManagementSystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RolesGetResponseDto {
    private Integer roleId;

    private String role;
}
