package com.auchan.gestionauchan.service.impl;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.data.repositories.ArticleRepository;
import com.auchan.gestionauchan.data.repositories.CategorieRepository;
import com.auchan.gestionauchan.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Article create(Article articleRequest) {
        var categorie = categorieRepository.findById(articleRequest.getCategorie().getId()).orElse(null);
        if (categorie == null) return null;
        articleRequest.setCategorie(categorie);
        return articleRepository.save(articleRequest);
    }

    @Override
    public Article update(Long id, Article articleRequest) {
        Optional<Article> optionalArticle= articleRepository
                .findById(id);
        var categorie= categorieRepository.findById(articleRequest.getCategorie().getId()).orElse(null);
        if(optionalArticle.isPresent() && categorie != null) {
            var article = optionalArticle.get();
            article.setCode(articleRequest.getCode());
            article.setName(articleRequest.getName());
            article.setPrix(articleRequest.getPrix());
            article.setCategorie(categorie);
            article.setQteStock(articleRequest.getQteStock());
            return articleRepository.save(article);
        }
        return null;
    }

    @Override
    public Article getById(Long id) {
        //return articleRepository.findById(id).get();  1st method si c'est sûr que le résultat sera obtenu
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Article> optionalArticle= articleRepository
                .findById(id);
        if(optionalArticle.isPresent()){
            var article = optionalArticle.get();
            articleRepository.delete(article);
            return true;
        }
        return false;
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }
}
