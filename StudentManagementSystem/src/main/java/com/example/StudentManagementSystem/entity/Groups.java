package com.example.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Groups {
    @Id
    @Column(name = "groups_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer groupId;

    @Column(name = "group_number")
    private Integer groupNumber;

    @Column(name = "group_year")
    private Integer groupYear;
}
