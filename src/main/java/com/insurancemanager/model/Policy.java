package com.insurancemanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Number is required")
    private Long number;

    @NotBlank(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private PolicyType type;

    @NotBlank(message = "Issue date is required")
    private LocalDate issueDate;

    @NotBlank(message = "Expire date is required")
    private LocalDate expireDate;

    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insuranceproduct_id")
    private InsuranceProduct insuranceproduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent;
}
