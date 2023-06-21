package com.insurancemanager.service;


import com.insurancemanager.model.Policy;

import java.util.List;


public interface PolicyService {
    Policy savePolicy(Policy policy);
    List<Policy> getAllPolicies();

    Policy getPolicyById(Long id);

    void updatePolicy(Policy policy);

    void deletePolicy(Long id);


}
