package com.auchan.gestionauchan.web.dto.response;

import com.auchan.gestionauchan.data.entities.Article;
import lombok.Data;

@Data
public class ArticleOneResponse {
    private Long id;

    private String code;

    private String name;

    private Double prix;

    private int qteStock;

    private CategorieAllResponse categorie;

    public ArticleOneResponse(Article article) {
        this.categorie = new CategorieAllResponse(article.getCategorie());
        this.code = article.getCode();
        this.id = article.getId();
        this.name = article.getName();
        this.prix = article.getPrix();
        this.qteStock = article.getQteStock();
    }
}
