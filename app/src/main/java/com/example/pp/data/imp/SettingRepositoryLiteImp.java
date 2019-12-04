package com.example.pp.data.imp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pp.data.AppDBHelper;
import com.example.pp.data.SettingRepositoryLite;
import com.example.pp.model.Setting;

import java.util.ArrayList;
import java.util.List;

import static com.example.pp.data.imp.setting.SettingContract.*;

public class SettingRepositoryLiteImp implements SettingRepositoryLite {
    private AppDBHelper helper;
    private SQLiteDatabase db;

    public SettingRepositoryLiteImp(Context context) {
        this.helper = new AppDBHelper(context);
    }

    @Override
    public boolean save(Setting setting) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY, setting.getKey());
        values.put(VALUE, setting.getValue());

        long newID = db.insert(TABLE_NAME, null, values);

        db.close();

        return newID > 0;
    }

    @Override
    public Setting get(String key) {
        db = helper.getReadableDatabase();

        try(Cursor cursor = db.query(
                TABLE_NAME,
                PROJECTION,
                null,
                null,
                null,
                null,
                null)){
            int idIndex = cursor.getColumnIndex(_ID);
            int keyIndex = cursor.getColumnIndex(KEY);
            int valueIndex = cursor.getColumnIndex(VALUE);

            while (cursor.moveToNext()){

                String expectedKey = cursor.getString(keyIndex);

                if(expectedKey.equals(key)) {
                    Setting setting = new Setting();
                    setting.setId(cursor.getInt(idIndex));
                    setting.setKey(expectedKey);
                    setting.setValue(cursor.getString(valueIndex));

                    db.close();
                    return setting;
                }
            }
        }

        db.close();

        return null;
    }

    @Override
    public boolean delete(Setting setting) {
        db = helper.getWritableDatabase();

        int id = db.delete(TABLE_NAME, KEY + "= ?", new String[]{setting.getKey()});

        db.close();

        return id > 0;
    }

    @Override
    public boolean update(Setting setting) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VALUE, setting.getValue());

        int id = db.update(TABLE_NAME, values,
                KEY + "= ?", new String[]{setting.getKey()});

        db.close();

        return id > 0;
    }

    @Override
    public List<Setting> getAll() {
        List<Setting> result = new ArrayList<>();

        db = helper.getReadableDatabase();

        try(Cursor cursor = db.query(
                TABLE_NAME,
                PROJECTION,
                null,
                null,
                null,
                null,
                null

        )){
            int idIndex = cursor.getColumnIndex(_ID);
            int keyIndex = cursor.getColumnIndex(KEY);
            int valueIndex = cursor.getColumnIndex(VALUE);

            while (cursor.moveToNext()){
                Setting setting = new Setting();
                setting.setId(cursor.getInt(idIndex));
                setting.setKey(cursor.getString(keyIndex));
                setting.setValue(cursor.getString(valueIndex));

                result.add(setting);
            }
        }

        db.close();

        return result;
    }
}
