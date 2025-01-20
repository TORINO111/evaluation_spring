package com.auchan.gestionauchan.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom_complet")
    private String nomComplet;

    @Column
    private String telephone;

    @Column
    private String pays;

    @OneToMany(mappedBy = "client")
    List<Commande> commandes;




}
