package com.insurancemanager.service;


import com.insurancemanager.model.Agent;

import java.util.List;

public interface AgentService {
    Agent saveAgent(Agent agent);

    List<Agent> getAllAgents();

    Agent getAgentById(Long id);

    void updateAgent(Agent client);

    void deleteAgent(Long id);
}
