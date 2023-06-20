package com.example.insurancemanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "insuranceproducts")
public class InsuranceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private double price;
}
