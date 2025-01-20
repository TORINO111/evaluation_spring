package com.auchan.gestionauchan.web.dto.request;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.data.entities.DetailCommande;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetailCommandeCreateRequest {

    @NotNull(message = "L'ID de l'article est obligatoire")
    private Long articleId;

    @NotNull(message = "La quantité est obligatoire")
    private Integer quantite;

    @NotNull(message = "Le prix unitaire est obligatoire")
    private Double prixUnitaire;

    public DetailCommande toEntity() {
        var entity = new DetailCommande();
        var article = new Article();
        article.setId(articleId);

        entity.setArticle(article);
        entity.setQuantite(quantite);
        entity.setPrixUnitaire(prixUnitaire);
        return entity;
    }
}
