package com.example.pp._old._model;

import com.example.pp._old._model.Product;

import java.util.List;
import java.util.Optional;

public interface StoreProduct<Entity> {

    Optional<Long> create(Product product);

    List<Entity> readAll();

    Optional<Entity> read(long id);

    Optional<Entity> update(Entity item);

    Optional<Entity> delete(long id);
}