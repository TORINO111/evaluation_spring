package com.auchan.gestionauchan.data.mock;

import com.auchan.gestionauchan.data.entities.Categorie;
import com.auchan.gestionauchan.data.repositories.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
//@Component
@Order(1)
public class CategorieMock implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        List< Categorie> categories = new ArrayList<Categorie>();

        for(int i = 0; i < 10; i++){
            Categorie categorie = new Categorie();
            categorie.setCode("Code"+i);
            categorie.setName("Name"+i);
            categories.add(categorie);
        }
        categorieRepository.saveAllAndFlush(categories);

    }
}
