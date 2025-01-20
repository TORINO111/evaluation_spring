package com.auchan.gestionauchan.service;

import com.auchan.gestionauchan.data.entities.Client;
import com.auchan.gestionauchan.data.entities.Commande;

public interface CommandeService extends CrudService<Commande> {
    boolean getByTel(String tel);

}
