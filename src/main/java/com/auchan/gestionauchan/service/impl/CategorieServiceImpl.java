package com.auchan.gestionauchan.service.impl;

import com.auchan.gestionauchan.data.entities.Categorie;
import com.auchan.gestionauchan.data.repositories.CategorieRepository;
import com.auchan.gestionauchan.service.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie create(Categorie categorieRequest) {
        return categorieRepository.save(categorieRequest);
    }

    @Override
    public Categorie update(Long id, Categorie categorieRequest) {
        Categorie cate = categorieRepository
                            .findById(id)
                            .orElse(null);
        if(cate != null){
            cate.setCode(categorieRequest.getCode());
            cate.setName(categorieRequest.getName());
            cate = categorieRepository.save(cate);
        }
        return cate;
    }

    @Override
    public Categorie getById(Long id) {
        return categorieRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Categorie cate = categorieRepository
                .findById(id)
                .orElse(null);
        if(cate != null){
            categorieRepository.delete(cate);
            return true;
        }
        return false;
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }
}
