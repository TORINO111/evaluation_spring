package com.auchan.gestionauchan.data.repositories;

import com.auchan.gestionauchan.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    boolean existsClientByTelephoneLike(String telephone);
}

