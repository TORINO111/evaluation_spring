package com.auchan.gestionauchan.web.dto.response;

import com.auchan.gestionauchan.data.entities.Client;
import jakarta.persistence.Column;

public class ClientWithCommandeResponse {
    private String nomComplet;

    private String telephone;

    private String pays;

    public ClientWithCommandeResponse(Client client) {
        this.nomComplet = nomComplet;
        this.pays = pays;
        this.telephone = telephone;
    }
}
