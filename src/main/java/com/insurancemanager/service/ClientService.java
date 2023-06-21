package com.insurancemanager.service;

import com.insurancemanager.model.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);

    List<Client> getAllClients();

    Client getClientById(Long id);

    void updateClient(Client client);

    void deleteClient(Long id);
}
