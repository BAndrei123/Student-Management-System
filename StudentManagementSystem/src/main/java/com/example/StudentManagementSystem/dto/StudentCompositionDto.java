package com.example.StudentManagementSystem.dto;

import com.example.StudentManagementSystem.entity.Credentials;
import com.example.StudentManagementSystem.entity.Groups;
import com.example.StudentManagementSystem.entity.Students;
import com.example.StudentManagementSystem.entity.Credentials;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StudentCompositionDto {
    private Students student;
    private Credentials credentials;
    private Groups group;
}
