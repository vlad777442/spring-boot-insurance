package com.insurancemanager.repository;

import com.insurancemanager.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    boolean existsAgentByEmailOrPhoneNumber(String email, String phone);
}
