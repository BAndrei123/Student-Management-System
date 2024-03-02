package com.example.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Credentials {

    @Id
    @Column(name = "credentials_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer credentialsID;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private Integer role;
}
