package com.auchan.gestionauchan.data.mock;

import com.auchan.gestionauchan.data.entities.Article;
import com.auchan.gestionauchan.data.entities.Categorie;
import com.auchan.gestionauchan.data.repositories.ArticleRepository;
import com.auchan.gestionauchan.data.repositories.CategorieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
@Order(2)
public class ArticleMock implements CommandLineRunner {
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;

    public ArticleMock(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Article> articles = new ArrayList<Article>();
        var categories = categorieRepository.findAll();

        for (Categorie categorie : categories) {
            for(int i = 0; i < 5; i++){
                Article article = new Article();
                article.setCode("Code "+ categorie.getName() +i);
                article.setName("Name " + categorie.getId() +i);
                article.setPrix(20000.0+i);
                article.setQteStock(200+i);

                article.setCategorie(categorie);
                articles.add(article);
            }
        }
        System.out.println("Nombre d'articles à sauvegarder : " + articles.size());
        articleRepository.saveAllAndFlush(articles);
    }
}
