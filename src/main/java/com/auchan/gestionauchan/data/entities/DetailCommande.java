package com.auchan.gestionauchan.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetailCommande {

    @Id
    @GeneratedValue
    private Long id;

    @Column()
    private Integer quantite;

    @Column()
    private Double prixUnitaire;

    @ManyToOne()
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne()
    @JoinColumn(name = "article_id")
    private Article article;
}
