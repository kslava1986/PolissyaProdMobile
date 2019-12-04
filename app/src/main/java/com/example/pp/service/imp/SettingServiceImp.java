package com.example.pp.service.imp;

import android.content.Context;

import com.example.pp.service.SettingService;
import com.example.pp.data.SettingRepositoryLite;
import com.example.pp.data.imp.SettingRepositoryLiteImp;
import com.example.pp.model.Setting;

public class SettingServiceImp implements SettingService {
    private SettingRepositoryLite repository;

    public SettingServiceImp(Context context) {
        this.repository = new SettingRepositoryLiteImp(context);
    }


    @Override
    public String getValue(String key) {
        Setting setting = repository.get(key);

        return setting != null ? repository.get(key).getValue() : "";
    }

    @Override
    public void setValue(String key, String value) {
        Setting setting = new Setting(key, value);
        repository.save(setting);
    }

    @Override
    public void delete(String key) {
        Setting setting = repository.get(key);
        if(setting != null) {
            repository.delete(setting);
        }
    }

    @Override
    public void updateValue(String key, String value) {
        Setting setting = repository.get(key);
        if(setting != null) {
            setting.setValue(value);
            repository.update(setting);
        }
    }

    @Override
    public boolean isExist(String key) {
        return repository.get(key) != null;
    }
}
