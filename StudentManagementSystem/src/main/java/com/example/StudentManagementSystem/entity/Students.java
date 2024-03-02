package com.example.StudentManagementSystem.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Students {
    @Id
    @Column(name = "students_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "credentials", referencedColumnName = "credentials_id")
    private Credentials credentials;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "groups", referencedColumnName = "groups_id")
    private Groups group;

    @ManyToOne
    @JoinColumn(name = "scholarship", referencedColumnName = "scholarship_id")
    private Scholarship scholarship;

    @Column(name = "integralist")
    private Boolean integralist;

    @ManyToOne
    @JoinColumn(name = "dorms", referencedColumnName = "dorms_id")
    private Dorms dorms;
}
