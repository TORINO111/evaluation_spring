package com.auchan.gestionauchan.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="articles")
public class Article extends AbstractType{

    @Column(nullable = false, name="prix_article")
    private Double prix;

    @Column(nullable = false, name="qte_stock")
    private Integer qteStock;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "article")
    private List<DetailCommande> details;
}
