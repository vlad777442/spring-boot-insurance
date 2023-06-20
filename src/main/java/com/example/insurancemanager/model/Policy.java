package com.example.insurancemanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    @Enumerated(EnumType.STRING)
    private PolicyType type;

    private LocalDateTime issueDate;

    private LocalDateTime expireDate;

    private boolean isActive;
}
