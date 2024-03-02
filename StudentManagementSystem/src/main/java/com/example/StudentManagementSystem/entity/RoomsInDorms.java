package com.example.StudentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roomsindorms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomsInDorms {
    @Id
    @Column(name = "rooms_in_dorms_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roomId;

    @Column(name = "room_number")
    private Integer roomNumber;
}
