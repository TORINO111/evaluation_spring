package com.auchan.gestionauchan.web.dto.request;

import com.auchan.gestionauchan.data.entities.Client;
import com.auchan.gestionauchan.data.entities.Categorie;
import com.auchan.gestionauchan.data.entities.Commande;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ClientWithCommandeRequest {

    private Long id;

    @NotBlank(message = "Le nom complet est obligatoire")
    private String nomComplet;

    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    @Size(min = 8, max = 15, message = "Le numéro de téléphone doit contenir entre 8 et 15 caractères")
    private String telephone;

    @NotBlank(message = "La saisie du pays est obligatoire")
    @Size(min = 8, message = "Le pays doit contenir au moins 4 caractères")
    private String pays;

    @NotNull(message = "Les commandes sont obligatoires")
    @Size(min = 1, message = "Un client doit avoir au moins une commande")
    private List<CommandeCreateRequest> commandes;

    //private Long commandeId;

    public Client toEntity(){
        var entity = new Client();
        //commande.setId(commandeId);

        //entity.getCommandes().add(commande);
        entity.setPays(pays);
        entity.setNomComplet(nomComplet);
        entity.setTelephone(telephone);
        entity.setId(id);
        var commandesEntities = commandes.stream()
                .map(CommandeCreateRequest::toEntity)
                .toList();
        commandesEntities.forEach(commande -> commande.setClient(entity));
        entity.setCommandes(commandesEntities);

        return entity;
    }
}
