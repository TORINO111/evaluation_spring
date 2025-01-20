package com.auchan.gestionauchan.data.repositories;

import com.auchan.gestionauchan.data.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Article,Long> {
}
