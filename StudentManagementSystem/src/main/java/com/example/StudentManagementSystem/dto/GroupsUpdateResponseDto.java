package com.example.StudentManagementSystem.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class GroupsUpdateResponseDto {
    private Integer groupId;

    private Integer groupNumber;

    private Integer groupYear;
}
