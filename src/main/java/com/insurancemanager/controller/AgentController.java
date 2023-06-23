package com.insurancemanager.controller;

import com.insurancemanager.model.Agent;
import com.insurancemanager.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @GetMapping("/add")
    public String showAgentForm(Model model) {
        model.addAttribute("agent", new Agent());
        return "create_agent";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("agent") Agent agent) {
        agentService.saveAgent(agent);
        return "redirect:/agents/findall";
    }

    @GetMapping("/findall")
    public String getAllAgents(Model model) {
        model.addAttribute("agents", agentService.getAllAgents());
        return "all_agents";
    }

    @GetMapping("{id}/update")
    public String showUpdateAgentForm(@PathVariable Long id, Model model) {
        model.addAttribute("agent", agentService.getAgentById(id));
        return "edit_agent";
    }

    @PostMapping("{id}/update")
    public String showUpdateAgentForm(@PathVariable Long id, @ModelAttribute("agent") Agent updatedAgent) {
        Agent agent = agentService.getAgentById(id);

        agent.setFirstName(updatedAgent.getFirstName());
        agent.setLastName(updatedAgent.getLastName());
        agent.setEmail(updatedAgent.getEmail());
        agent.setPhoneNumber(updatedAgent.getPhoneNumber());

        agentService.updateAgent(agent);
        return "redirect:/agents/findall";
    }

    @GetMapping("{id}/delete")
    public String deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return "redirect:/agents/findall";
    }
}
