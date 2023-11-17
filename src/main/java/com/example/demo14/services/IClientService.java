package com.example.demo14.services;

import com.example.demo14.entities.Client;

import java.util.List;

public interface IClientService {

    List<Client> retrieveAllClients();

    Client addClient(Client c);

    void deleteClient(Long id);

    Client updateClient(Client c);

    Client retrieveClient(Long id);
}
