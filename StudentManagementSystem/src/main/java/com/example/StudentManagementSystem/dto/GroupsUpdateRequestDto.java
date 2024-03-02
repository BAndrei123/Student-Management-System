package com.example.StudentManagementSystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupsUpdateRequestDto {
    private Integer groupId;

    private Integer groupNumber;
}
