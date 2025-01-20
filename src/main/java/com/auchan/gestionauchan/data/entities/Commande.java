package com.auchan.gestionauchan.data.entities;

import jakarta.persistence.*;

import java.util.Date;

public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Date date;

    @Column(nullable = false)
    Double montant;



    @ManyToOne
    Client client;
}
