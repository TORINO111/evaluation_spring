package com.auchan.gestionauchan.web.controllers;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.web.dto.request.ArticleCreateRequest;
import com.auchan.gestionauchan.web.dto.response.ArticleAllResponse;
import com.auchan.gestionauchan.web.dto.response.ArticleOneResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public interface ArticleController {
    @GetMapping("/list")
    ResponseEntity<List<ArticleAllResponse>> getAllArticle();

    @GetMapping("/one/{id}")
    ResponseEntity<ArticleOneResponse> getOneArticle(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<ArticleOneResponse> createArticle(@RequestBody ArticleCreateRequest articleRequest);

    @PutMapping("/update/{id}")
    ResponseEntity<Article> updateArticle(@PathVariable() Long id, @RequestBody() Article article);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteArticle(@PathVariable() Long id);

}
