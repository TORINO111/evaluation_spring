package com.auchan.gestionauchan.web.dto.request;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.data.entities.Categorie;
import com.auchan.gestionauchan.web.dto.response.CategorieAllResponse;
import lombok.Data;

@Data
public class ArticleCreateRequest {
    private Long id;

    private String code;

    private String name;

    private Double prix;

    private Integer qteStock;

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
