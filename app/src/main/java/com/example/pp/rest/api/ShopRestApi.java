package com.example.pp.rest.api;

import com.example.pp.model.Shop;
import com.example.pp.rest.ApiRestRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopRestApi extends ApiRestRequest {

    @GET("/shops")
    Call<List<Shop>> getAll();
}
