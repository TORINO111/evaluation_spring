package com.auchan.gestionauchan.web.controllers.impl;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.service.ArticleService;
import com.auchan.gestionauchan.web.controllers.ArticleController;
import com.auchan.gestionauchan.web.dto.request.ArticleCreateRequest;
import com.auchan.gestionauchan.web.dto.response.ArticleAllResponse;
import com.auchan.gestionauchan.web.dto.response.ArticleOneResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleControllerImpl implements ArticleController {
    private final ArticleService articleService;

    public ArticleControllerImpl(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ResponseEntity<List<ArticleAllResponse>> getAllArticle() {
        var articles = articleService.getAllArticle();
        //mappage ==> conversion des entity en dto
        var articlesResponse = articles.stream().map(ArticleAllResponse::new).toList();   //Autre méthode: .map(entity -> new ArticleAllResponse(entity)
        return new ResponseEntity<>(articlesResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> getOneArticle(Long id) {
        var article = articleService.getById(id);
        return new ResponseEntity<>(new ArticleOneResponse(article), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> createArticle(ArticleCreateRequest articleRequest) {
        var article= articleService.create(articleRequest.toEntity());
        return new ResponseEntity<>(new ArticleOneResponse(article), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Article> updateArticle(Long id, Article article) {
        var articleUpdate= articleService.update(id, article);
        return new ResponseEntity<>(articleUpdate, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<String> deleteArticle(Long id) {
        var isDeleted = articleService.delete(id);
        return new ResponseEntity<>(isDeleted ? "Article supprimé avec succès" : "Erreur de suppression de l'article!", HttpStatus.OK);
    }
}
