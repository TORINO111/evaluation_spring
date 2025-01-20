package com.auchan.gestionauchan.service;


import java.util.List;

public interface CrudService<T> {
    T create(T objectRequest);
    T update(Long id, T objectRequest);
    T getById(Long id);
    List<T> getAll();
    boolean delete(Long id);
}
