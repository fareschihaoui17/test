package com.example.demo14.services;

import com.example.demo14.entities.Client;
import com.example.demo14.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ClientServiceImpl implements IClientService{

    private ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
      var client=clientRepository.findById(id).orElseThrow(()-> new RuntimeException("client introuvable"));
      clientRepository.delete(client);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.findById(c.getIdClient()).map(client -> {
            client.setNom(c.getNom());
            client.setCategorieClient(c.getCategorieClient());
            client.setEmail(c.getEmail());
            client.setDateNaissance(c.getDateNaissance());
            client.setPrenom(c.getPrenom());
            client.setProfession(c.getProfession());
            client.setFactures(c.getFactures());
            client.setPassword(c.getPassword());
            return client;
        }).orElseThrow(()->new RuntimeException("client introuvable"));
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).orElseThrow(()->new RuntimeException("client introuvable"));
    }
}
