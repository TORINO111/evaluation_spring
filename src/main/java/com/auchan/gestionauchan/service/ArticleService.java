package com.auchan.gestionauchan.service;

import com.auchan.gestionauchan.data.entities.Article;

import java.util.List;

public interface ArticleService {
    Article create(Article ArticleRequest);
    Article update(Long id,Article ArticleRequest);
    Article getById(Long id);
    boolean delete(Long id);
    List<Article> getAllArticle();
}
