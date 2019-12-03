package com.example.pp.activity.controller;

import android.content.Context;
import android.util.Log;

import com.example.pp.Services.SettingService;
import com.example.pp.Services.ShopsService;
import com.example.pp.Services.imp.SettingServiceImp;
import com.example.pp.data.default_data.ShopDefault;

public class LoadControllerImp implements LoadingController {
    private final SettingService settingService;
    private final ShopsService shopsService;


    public LoadControllerImp(Context context) {
        this.settingService = new SettingServiceImp(context);
        this.shopsService = new ShopsService(context);
    }

    @Override
    public void loadData() {
        Log.i("*****************", "In load controller");
        shopsService.saveToBaseData(ShopDefault.SHOPS);
    }
}
