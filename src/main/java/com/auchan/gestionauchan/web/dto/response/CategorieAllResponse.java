package com.auchan.gestionauchan.web.dto.response;

import com.auchan.gestionauchan.data.entities.Categorie;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CategorieAllResponse {
    private Long id;

    private String code;

    private String name;

    public CategorieAllResponse(Categorie categorie) {
        this.code = categorie.getCode();
        this.id = categorie.getId();
        this.name = categorie.getName();
    }
}
