package com.example.pp.rest.api;

import com.example.pp.models.Shop;
import com.example.pp.rest.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopRestApi extends ApiService {

    @GET("/shops")
    Call<List<Shop>> getAll();
}
