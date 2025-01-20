package com.auchan.gestionauchan.service;

import com.auchan.gestionauchan.data.entities.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie create(Categorie categorieRequest);
    Categorie update(Long id,Categorie categorieRequest);
    Categorie getById(Long id);
    boolean delete(Long id);
    List<Categorie> getAllCategorie();
}
