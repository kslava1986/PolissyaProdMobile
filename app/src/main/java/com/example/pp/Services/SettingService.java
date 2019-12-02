package com.example.pp.Services;

public interface SettingService {
    String getValue(String key);
    void setValue(String key, String value);
    void delete(String key);
}
