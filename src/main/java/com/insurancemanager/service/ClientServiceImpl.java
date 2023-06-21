package com.insurancemanager.service;

import com.insurancemanager.exception.ClientNotFoundException;
import com.insurancemanager.model.Client;
import com.insurancemanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> dbClient = clientRepository.findById(id);
        if (dbClient.isPresent()) {
            return dbClient.get();
        } else {
            throw new ClientNotFoundException("Client with Id : \"+id+\" Not Found");
        }
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete(getClientById(id));
    }
}
