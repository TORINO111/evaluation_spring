package com.auchan.gestionauchan.web.dto.request;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.data.entities.Categorie;
import com.auchan.gestionauchan.web.dto.response.CategorieAllResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ArticleCreateRequest {
    private Long id;

    @NotEmpty(message = "Le code de l'article est obligatoire")
    private String code;

    @NotEmpty(message = "Le nom de l'article est obligatoire")
    private String name;

    @NotNull(message = "Le prix est obligatoire")
    private Double prix;

    @NotNull(message = "La quantité en stock est obligatoire")
    @Size(min = 1)
    private Integer qteStock;

    @NotNull(message = "La catégorie de l'article est obligatoire")
    private Long categorieId;

    public Article toEntity(){
        var entity = new Article();
        var categorie = new Categorie();
        categorie.setId(categorieId);

        entity.setCategorie(categorie);
        entity.setId(id);
        entity.setCode(code);
        entity.setName(name);
        entity.setPrix(prix);
        entity.setQteStock(qteStock);
        return entity;
    }
}
