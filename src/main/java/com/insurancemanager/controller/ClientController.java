package com.insurancemanager.controller;

import com.insurancemanager.model.Client;
import com.insurancemanager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients/findall";
    }

    @GetMapping("/findall")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping ("{id}/update")
    public String showUpdateClientForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "edit_client";
    }

    @PostMapping("{id}/update")
    public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client updatedClient) {
        Client client = clientService.getClientById(id);

        client.setFirstName(updatedClient.getFirstName());
        client.setLastName(updatedClient.getLastName());
        client.setEmail(updatedClient.getEmail());
        client.setPhoneNumber(updatedClient.getPhoneNumber());

        clientService.saveClient(client);
        return "redirect:/clients/findall";
    }

    @GetMapping("{id}/delete")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients/findall";
    }
}
