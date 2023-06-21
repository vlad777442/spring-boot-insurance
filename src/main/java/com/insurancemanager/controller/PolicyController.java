package com.insurancemanager.controller;

import com.insurancemanager.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    PolicyService policyService;


    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("policies", policyService.getAllPolicies());
        return "policies";
    }
}
