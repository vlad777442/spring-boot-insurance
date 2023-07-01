package com.insurancemanager.service;

import com.insurancemanager.exception.PolicyNotFoundException;
import com.insurancemanager.model.Policy;
import com.insurancemanager.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public Policy getPolicyById(Long id) {
        Optional<Policy> dbPolicy = policyRepository.findById(id);
        if (dbPolicy.isPresent()) {
            return dbPolicy.get();
        } else {
            throw new PolicyNotFoundException("Policy with Id : \"+id+\" Not Found");
        }
    }

    @Override
    public void updatePolicy(Policy policy) {
        policyRepository.save(policy);
    }

    @Override
    public void deletePolicy(Long id) {
        policyRepository.delete(getPolicyById(id));
    }

    @Override
    public boolean isActive(Policy policy) {
        LocalDate currDateTime = LocalDate.now();
        return currDateTime.isAfter(policy.getIssueDate()) && currDateTime.isBefore(policy.getExpireDate());
    }

    @Override
    public List<Policy> getAllPoliciesByAgentId(Long id) {
        return policyRepository.getPoliciesByAgentId(id);
    }
}
