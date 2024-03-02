package com.example.StudentManagementSystem.dto;

import com.example.StudentManagementSystem.entity.Credentials;
import com.example.StudentManagementSystem.entity.Dorms;
import com.example.StudentManagementSystem.entity.Groups;
import com.example.StudentManagementSystem.entity.Scholarship;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsAddRequestDto {
    private String name;

    private Integer age;

    private Integer credentials;

    private String phoneNumber;

    private Integer group;

    private Integer scholarship;

    private Boolean integralist;

    private Integer dorms;
}
