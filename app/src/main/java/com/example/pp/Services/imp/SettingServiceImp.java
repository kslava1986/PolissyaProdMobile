package com.example.pp.Services.imp;

import android.content.Context;

import com.example.pp.Services.SettingService;
import com.example.pp.data.SettingRepositoryLite;
import com.example.pp.data.imp.SettingRepositoryLiteImp;
import com.example.pp.models._new.Setting;

public class SettingServiceImp implements SettingService {
    private SettingRepositoryLite repository;

    public SettingServiceImp(Context context) {
        this.repository = new SettingRepositoryLiteImp(context);
    }


    @Override
    public String getValue(String key) {
        return repository.get(key).getValue();
    }

    @Override
    public void setValue(String key, String value) {
        Setting setting = repository.get(key);
        setting.setValue(value);
        repository.update(setting);
    }

    @Override
    public void delete(String key) {
        Setting setting = repository.get(key);
        repository.delete(setting);
    }
}
