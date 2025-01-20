package com.auchan.gestionauchan.service.impl;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.data.entities.Client;
import com.auchan.gestionauchan.data.repositories.ClientRepository;
import com.auchan.gestionauchan.data.repositories.CommandeRepository;
import com.auchan.gestionauchan.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final CommandeRepository commandeRepository;

    public ClientServiceImpl(ClientRepository clientRepository, CommandeRepository commandeRepository) {
        this.clientRepository = clientRepository;
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Client create(Client clientRequest) {
        return clientRepository.save(clientRequest);
    }

    @Override
    public Client update(Long id, Client clientRequest) {
        return null;
    }

    @Override
    public Client getById(Long id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean getByTel(String telephone) {
        if (clientRepository.existsClientByTelephoneLike(telephone)){
            return true;
        };
        return false;
    }
}
