package com.auchan.gestionauchan.data.repositories;

import com.auchan.gestionauchan.data.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
