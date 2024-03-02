package com.example.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dorms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dorms {
    @Id
    @Column(name = "dorms_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dormId;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "rooms_in_dorms", referencedColumnName = "rooms_in_dorms_id")
    private RoomsInDorms roomsInDorms;
}
