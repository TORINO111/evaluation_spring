package com.auchan.gestionauchan.web.controllers.impl;

import com.auchan.gestionauchan.data.entities.*;
import com.auchan.gestionauchan.service.CategorieService;
import com.auchan.gestionauchan.service.ClientService;
import com.auchan.gestionauchan.web.controllers.ClientController;
import com.auchan.gestionauchan.web.dto.request.ClientWithCommandeRequest;
import com.auchan.gestionauchan.web.dto.response.ArticleOneResponse;
import com.auchan.gestionauchan.web.dto.response.ClientWithCommandeResponse;
import jakarta.validation.Valid;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    private final CategorieService categorieService;

    public ClientControllerImpl(ClientService clientService, CategorieService categorieService) {
        this.clientService = clientService;
        this.categorieService = categorieService;
    }

    @Override
    public ResponseEntity<ClientWithCommandeResponse> createClient(ClientWithCommandeRequest clientRequest) {
        var client = clientService.create(clientRequest.toEntity());
        return new ResponseEntity<>(new ClientWithCommandeResponse(client), HttpStatus.CREATED);
    }

    public ResponseEntity<Client> createClientWithCommandes(@Valid @RequestBody ClientWithCommandeRequest request) {
        if (clientService.getByTel(request.getTelephone())) {
            return ResponseEntity.badRequest().body(null);
        }

        Client client = request.toEntity();

        List<Commande> commandes = request.getCommandes().stream().map(cmdReq -> {
            Commande commande = cmdReq.toEntity();
            commande.setClient(client);

            List<DetailCommande> details = cmdReq.getArticles().stream().map(articleReq -> {
                Article article = articleReq.toEntity();

                Categorie categorie = categorieRepository.findById(articleReq.getCategorieId())
                        .orElseThrow(() -> new IllegalArgumentException("Catégorie introuvable avec l'ID : " + articleReq.getCategorieId()));
                article.setCategorie(categorie);

                DetailCommande detail = new DetailCommande();
                detail.setArticle(article);
                detail.setCommande(commande);
                detail.setQuantite(articleReq.getQteStock());

                return detail;
            }).toList();

            commande.setDetailsCommande(details);

            return commande;
        }).toList();

        client.setCommandes(commandes);

        Client savedClient = clientService.create(client);

        return ResponseEntity.ok(savedClient);
    }


    @Override
    public ResponseEntity<ClientWithCommandeResponse> getClientCommandes(int id) {
        return null;
    }
}
