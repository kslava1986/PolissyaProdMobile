package com.example.pp.data;

import com.example.pp.model.Shop;

import java.util.List;

public interface ShopRepositoryLite {
    //todo реализовать выбор модели по нескольким параметрам
    Shop get();
    int save(Shop shop);
    void delete(Shop shop);
    void update(Shop shop);
    List<Shop> getAll();
}
