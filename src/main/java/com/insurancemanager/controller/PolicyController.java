package com.insurancemanager.controller;

import com.insurancemanager.model.Policy;
import com.insurancemanager.model.PolicyType;
import com.insurancemanager.service.AgentService;
import com.insurancemanager.service.ClientService;
import com.insurancemanager.service.InsuranceProductService;
import com.insurancemanager.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @Autowired
    ClientService clientService;

    @Autowired
    AgentService agentService;

    @Autowired
    InsuranceProductService productService;

    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("policies", policyService.getAllPolicies());
        return "all_policies";
    }

    @GetMapping("/add")
    public String showPolicyForm(Model model) {
        model.addAttribute("policy", new Policy());
        model.addAttribute("types", PolicyType.values());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("agents", agentService.getAllAgents());
        model.addAttribute("products", productService.getAllInsuranceProducts());
        return "create_policy";
    }

    @PostMapping("/save")
    public String savePolicy(@ModelAttribute("policy") @Valid Policy policy, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create_policy";
        }

        if (policyService.isActive(policy))
            policy.setIsActive(true);
        else policy.setIsActive(false);
        policyService.savePolicy(policy);
        return "redirect:/policies/findall";
    }

    @GetMapping("{id}/update")
    public String showUpdatePolicyForm(@PathVariable Long id, Model model) {
        model.addAttribute("policy", policyService.getPolicyById(id));
        model.addAttribute("types", PolicyType.values());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("agents", agentService.getAllAgents());
        model.addAttribute("products", productService.getAllInsuranceProducts());
        return "edit_policy";
    }

    @PostMapping("{id}/update")
    public String updatePolicy(@PathVariable Long id,
                               @ModelAttribute("policy") @Valid Policy updatedPolicy,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_policy";
        }
        Policy policy = policyService.getPolicyById(id);

        policy.setNumber(updatedPolicy.getNumber());
        policy.setType(updatedPolicy.getType());
        policy.setIssueDate(updatedPolicy.getIssueDate());
        policy.setExpireDate(updatedPolicy.getExpireDate());
        policy.setClient(updatedPolicy.getClient());
        policy.setAgent(updatedPolicy.getAgent());
        policy.setInsuranceproduct(updatedPolicy.getInsuranceproduct());

        if (policyService.isActive(policy))
            policy.setIsActive(true);
        else policy.setIsActive(false);

        policyService.updatePolicy(policy);
        return "redirect:/policies/findall";
    }

    @GetMapping("/{id}/delete")
    public String deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return "redirect:/policies/findall";
    }
}
