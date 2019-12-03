package com.example.pp.data;

import com.example.pp.models.Setting;

import java.util.List;

public interface SettingRepositoryLite {
    boolean save(Setting setting);
    Setting get(String key);
    boolean delete(Setting setting);
    boolean update(Setting setting);
    List<Setting> getAll();
}
