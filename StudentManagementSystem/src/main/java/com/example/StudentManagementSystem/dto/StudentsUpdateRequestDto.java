package com.example.StudentManagementSystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsUpdateRequestDto {
    private Integer studentId;

    private String name;

    private Integer age;

    private Integer credentials;

    private String phoneNumber;

    private Integer group;

    private Integer scholarship;

    private Boolean integralist;

    private Integer dorms;
}
