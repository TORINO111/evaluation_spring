package com.auchan.gestionauchan.data.repositories;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.data.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
