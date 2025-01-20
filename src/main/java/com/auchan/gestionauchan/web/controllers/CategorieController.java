package com.auchan.gestionauchan.web.controllers;


import com.auchan.gestionauchan.data.entities.Categorie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public interface CategorieController {

    @GetMapping("/list")
    ResponseEntity<List<Categorie>> getAllCategorie();

    @GetMapping("/one/{id}")
    ResponseEntity<Categorie> getOneCategorie(@PathVariable() Long id);

    @PostMapping("/create")
    ResponseEntity<Categorie> createCategorie(@RequestBody() Categorie categorieRequest);

    @PutMapping("/update/{id}")
    ResponseEntity<Categorie> updateCategorie(@PathVariable() Long id, Categorie categorie);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Boolean> deleteCategorie(@PathVariable() Long id);

}
