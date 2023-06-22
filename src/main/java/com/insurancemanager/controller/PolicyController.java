package com.insurancemanager.controller;

import com.insurancemanager.model.Policy;
import com.insurancemanager.model.PolicyType;
import com.insurancemanager.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("policies", policyService.getAllPolicies());
        return "policies";
    }

    @GetMapping("/create")
    public String createPolicyForm(Model model) {
        Policy policy = new Policy();
        model.addAttribute(policy);
        model.addAttribute("types", PolicyType.values());
        return "create_policy";
    }

    @PostMapping("/")
    public String savePolicy(@ModelAttribute("policy") Policy policy) {
        policyService.savePolicy(policy);
        return "redirect:/policies";
    }

    @GetMapping("/edit/{id}")
    public String editPolicyForm(@PathVariable Long id, Model model) {
        model.addAttribute("policy", policyService.getPolicyById(id));
        return "edit_policy";
    }

    @PostMapping("/{id}")
    public String updatePolicy(@PathVariable Long id,
                               @ModelAttribute("policy") Policy policy,
                               Model model) {
        Policy dbPolicy = policyService.getPolicyById(id);
        dbPolicy.setId(policy.getId());
        dbPolicy.setNumber(policy.getNumber());
        ///...
        policyService.updatePolicy(dbPolicy);
        return "redirect:/policies";
    }

    @GetMapping("/{id}")
    public String deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return "redirect:/policies";
    }

}
