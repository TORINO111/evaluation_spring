package com.auchan.gestionauchan.service.impl;

import com.auchan.gestionauchan.data.entities.Commande;
import com.auchan.gestionauchan.data.repositories.CommandeRepository;
import com.auchan.gestionauchan.service.CommandeService;

import java.util.List;

public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }


    @Override
    public Commande create(Commande objectRequest) {
        return null;
    }

    @Override
    public Commande update(Long id, Commande objectRequest) {
        return null;
    }

    @Override
    public Commande getById(Long id) {
        return null;
    }

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
