package com.example.pp.data;

import com.example.pp.models.Shop;

import java.util.List;

public interface ShopRepositoryLite {
    Shop get();
    int save(Shop shop);
    void delete(Shop shop);
    void update(Shop shop);
    List<Shop> getAll();
}
