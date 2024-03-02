package com.example.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "scholarship")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Scholarship {
    @Id
    @Column(name = "scholarship_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scholarshipId;

    @Column(name = "scholarship_type")
    private String scholarshipType;
}
