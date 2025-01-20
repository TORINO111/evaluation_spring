package com.auchan.gestionauchan.web.dto.response;

import com.auchan.gestionauchan.data.entities.Commande;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class CommandeOneResponse {
    Date date;

    Double montant;

    ArticleOneResponse article;

    public CommandeOneResponse(Commande commande) {
        this.article = article;

    }
}
