package com.insurancemanager.repository;

import com.insurancemanager.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> getPoliciesByAgentId(Long id);

    List<Policy> getPoliciesByClientId(Long id);

    List<Policy> getPoliciesByInsuranceproductId(Long id);
}
