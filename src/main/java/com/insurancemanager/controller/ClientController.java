package com.insurancemanager.controller;

import com.insurancemanager.model.Client;
import com.insurancemanager.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/add")
    public String showClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "create_client";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create_client";
        }
        clientService.saveClient(client);
        return "redirect:/clients/findall";
    }

    @GetMapping("/findall")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "all_clients";
    }

    @GetMapping ("{id}/update")
    public String showUpdateClientForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "edit_client";
    }

    @PostMapping("{id}/update")
    public String updateClient(@PathVariable Long id,
                               @ModelAttribute("client") @Valid Client updatedClient,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_client";
        }
        Client client = clientService.getClientById(id);

        client.setFirstName(updatedClient.getFirstName());
        client.setLastName(updatedClient.getLastName());
        client.setEmail(updatedClient.getEmail());
        client.setPhoneNumber(updatedClient.getPhoneNumber());

        clientService.updateClient(client);
        return "redirect:/clients/findall";
    }

    @GetMapping("{id}/delete")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients/findall";
    }
}
