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
public class StudentsGetResponseDto {

    private Integer studentId;

    private String name;

    private Integer age;

    private Credentials credentials;

    private String phoneNumber;

    private Groups group;

    private Scholarship scholarship;

    private Boolean integralist;

    private Dorms dorms;
}
