package com.example.pp.activity.controller;

import android.content.Context;

import com.example.pp.Services.SettingService;
import com.example.pp.Services.ShopsService;
import com.example.pp.Services.imp.SettingServiceImp;
import com.example.pp.data.default_data.SettingDefault;
import com.example.pp.data.default_data.ShopDefault;
import com.example.pp.data.imp.setting.SettingConst;
import com.example.pp.models.Shop;
import com.example.pp.rest.NetworkService;
import com.example.pp.rest.api.ShopRestApi;

import java.util.List;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadControllerImp implements LoadingController {
    private final SettingService settingService;
    private final ShopsService shopsService;
    private final NetworkService networkService;


    public LoadControllerImp(Context context) {
        this.settingService = new SettingServiceImp(context);
        this.shopsService = new ShopsService(context);
        this.networkService = createRestClient();
    }

    private NetworkService createRestClient(){
        if(settingService.isExist(SettingConst.CONNECTION_URL)){
            String url = settingService.getValue(SettingConst.CONNECTION_URL);
            NetworkService.setUrl(url);
        }
        return NetworkService.getInstance();
    }

    @Override
    public void load() {
        if(settingService.isExist(SettingConst.FIRST_RUN)){
            createNewSettings();
            //todo добавить список значений по умолчанию для первой инициализации базы при первом запуске програмы
            shopsService.saveToBaseData(ShopDefault.SHOPS);
        } else {

        }
        loadShops();
    }

    private void createNewSettings(){
        settingService.setValue(SettingConst.CONNECTION_URL, SettingDefault.BASE_CONNECTION_URL);


        settingService.setValue(SettingConst.FIRST_RUN, SettingDefault.FIRST_LOAD);
    }

    private void loadShops(){
        networkService
                .getJSONApi(ShopRestApi.class)
                .getAll()
                .enqueue(new Callback<List<Shop>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Shop>> call, @NonNull Response<List<Shop>> response) {
                        List<Shop> shops = response.body();
                        if(shops != null){
                            shopsService.saveToBaseData(shops);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Shop>> call, Throwable t) {
                        t.printStackTrace();
                        //todo убрать, так как при неудачной загрузке данные не должны записываться и обновляться
                        shopsService.saveToBaseData(ShopDefault.SHOPS);
                    }
                });
    }
}
