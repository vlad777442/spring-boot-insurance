package com.insurancemanager.service;

import com.insurancemanager.model.Policy;
import com.insurancemanager.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    PolicyRepository policyRepository;
    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
}
