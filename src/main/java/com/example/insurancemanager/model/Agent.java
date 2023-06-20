package com.example.insurancemanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
