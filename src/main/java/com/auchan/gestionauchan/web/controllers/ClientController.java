package com.auchan.gestionauchan.web.controllers;

import com.auchan.gestionauchan.web.dto.request.ClientWithCommandeRequest;
import com.auchan.gestionauchan.web.dto.response.ClientWithCommandeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public interface ClientController {
    @PostMapping("/commandes")
    ResponseEntity<ClientWithCommandeResponse> createClient(@RequestBody ClientWithCommandeRequest clientRequest);

    @GetMapping("/{id}/commandes")
    ResponseEntity<ClientWithCommandeResponse> getClientCommandes(@PathVariable int id);
}
