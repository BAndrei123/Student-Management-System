package com.example.StudentManagementSystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsDeleteResponseDto {
    private Integer studentId;

    private String name;
}
