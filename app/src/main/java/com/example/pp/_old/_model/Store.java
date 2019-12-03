package com.example.pp._old._model;


import com.example.pp._old._model.Shop;

import java.util.List;
import java.util.Optional;

public interface Store<Entity> {

    Optional<Long> create(Shop shop);

    List<Entity> readAll();

    Optional<Entity> read(long id);

    Optional<Entity> update(Entity item);

    Optional<Entity> delete(long id);
}
