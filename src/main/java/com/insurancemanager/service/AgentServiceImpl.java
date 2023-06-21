package com.insurancemanager.service;

import com.insurancemanager.exception.AgentNotFoundException;
import com.insurancemanager.model.Agent;
import com.insurancemanager.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepository;
    @Override
    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Agent getAgentById(Long id) {
        Optional<Agent> optional = agentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new AgentNotFoundException("Agent with Id : \"+id+\" Not Found");
        }
    }

    @Override
    public void updateAgent(Agent agent) {
        agentRepository.save(agent);
    }

    @Override
    public void deleteAgent(Long id) {
        agentRepository.delete(getAgentById(id));
    }
}
