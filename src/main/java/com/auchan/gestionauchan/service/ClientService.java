package com.auchan.gestionauchan.service;

import com.auchan.gestionauchan.data.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface ClientService extends CrudService <Client> {
    boolean getByTel(String telephone);
}
