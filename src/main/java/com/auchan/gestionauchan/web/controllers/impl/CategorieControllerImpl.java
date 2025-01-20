package com.auchan.gestionauchan.web.controllers.impl;

import com.auchan.gestionauchan.data.entities.Categorie;
import com.auchan.gestionauchan.service.CategorieService;
import com.auchan.gestionauchan.web.controllers.CategorieController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CategorieControllerImpl implements CategorieController {
    public final CategorieService categorieService;

    @Override
    public ResponseEntity<List<Categorie>> getAllCategorie() {
        var categories = categorieService.getAllCategorie();
          return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Categorie> getOneCategorie(Long id) {
        var categorie = categorieService.getById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Categorie> createCategorie(@RequestBody() Categorie categorie) {
        var create = categorieService.create(categorie);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Categorie> updateCategorie(Long id, @RequestBody()  Categorie categorie) {
        var update = categorieService.update(id, categorie);
        return new ResponseEntity<>(categorie, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Boolean> deleteCategorie(Long id) {
        var delete = categorieService.delete(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
