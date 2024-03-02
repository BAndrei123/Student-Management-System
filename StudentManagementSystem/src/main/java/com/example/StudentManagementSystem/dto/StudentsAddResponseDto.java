package com.example.StudentManagementSystem.dto;

import com.example.StudentManagementSystem.entity.Credentials;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsAddResponseDto {
    private Integer studentId;

    private String name;

    private Credentials credentials;
}
