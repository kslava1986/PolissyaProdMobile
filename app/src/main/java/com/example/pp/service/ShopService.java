package com.example.pp.service;

import com.example.pp.model.shop.Shop;

import java.util.List;

public interface ShopService {
    void save(Shop shop);
    void update(Shop shop);
    void saveAll(List<Shop>shops);
    List<Shop> getAll();
}
