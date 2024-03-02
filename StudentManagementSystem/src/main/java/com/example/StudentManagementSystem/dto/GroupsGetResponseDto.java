package com.example.StudentManagementSystem.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupsGetResponseDto {
    private Integer groupId;

    private Integer groupNumber;

    private Integer groupYear;
}
