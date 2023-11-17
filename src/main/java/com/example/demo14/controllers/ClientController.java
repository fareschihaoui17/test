package com.example.demo14.controllers;

import com.example.demo14.entities.Client;
import com.example.demo14.services.IClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@Slf4j
public class ClientController {

    private IClientService iClientService;

    @GetMapping("/all")
    public List<Client> retrieveAllClients() {
        log.info("retrieve all clients");
        return iClientService.retrieveAllClients();
    }

    @PostMapping("/add")
    public Client addClient(@RequestBody Client c) {
        return iClientService.addClient(c);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id) {
        iClientService.deleteClient(id);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody @Valid Client c) {
        return iClientService.updateClient(c);
    }
    @GetMapping("/get/{id}")
    public Client retrieveClient(@PathVariable Long id) {
        return iClientService.retrieveClient(id);
    }
}
