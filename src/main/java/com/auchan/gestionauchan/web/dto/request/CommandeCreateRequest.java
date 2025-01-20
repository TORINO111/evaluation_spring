package com.auchan.gestionauchan.web.dto.request;

import com.auchan.gestionauchan.data.entities.Commande;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CommandeCreateRequest {
    @NotEmpty(message = "La date est obligatoire")
    private String date;

    @NotNull(message = "Le montant est obligatoire")
    private Double montant;

    @NotNull(message = "Les articles sont obligatoires")
    @Size(min = 1, message = "Une commande doit avoir au moins un article")
    private List<DetailCommandeCreateRequest> detailsCommande;

    public Commande toEntity() {
        var entity = new Commande();
        entity.setDate(LocalDate.parse(this.date));
        entity.setMontant(this.montant);

        // Transformation des détails de commande
        var detailEntities = detailsCommande.stream()
                .map(DetailCommandeCreateRequest::toEntity)
                .toList();

        // Association de chaque détail à la commande
        detailEntities.forEach(detail -> detail.setCommande(entity));

        entity.setDetails(detailEntities);
        return entity;
    }
}