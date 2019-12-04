package com.example.pp.data.imp.shop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pp.data.AppDBHelper;
import com.example.pp.data.ShopRepositoryLite;
import com.example.pp.model.shop.Shop;

import java.util.ArrayList;
import java.util.List;

import static com.example.pp.data.imp.shop.ShopContract.*;


public class ShopRepositoryLiteImp implements ShopRepositoryLite {
    private AppDBHelper helper;
    private SQLiteDatabase db;

    public ShopRepositoryLiteImp(Context context) {
        this.helper = new AppDBHelper(context);
    }

    @Override
    public Shop get() {
        return null;
    }

    @Override
    public int save(Shop shop) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, shop.getName());
        values.put(TEL, shop.getTel());

        long newId = db.insert(TABLE_NAME, null, values);

        db.close();
        return (int)newId;
    }

    @Override
    public void delete(Shop shop) {
        db = helper.getWritableDatabase();

        db.delete(TABLE_NAME, _ID, new String[]{String.valueOf(shop.getId())});

        db.close();
    }

    @Override
    public void update(Shop shop) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, shop.getName());
        values.put(TEL, shop.getTel());

        db.update(TABLE_NAME, values, _ID, new String[]{String.valueOf(shop.getId())});

        db.close();
    }

    @Override
    public List<Shop> getAll() {
        List<Shop> shops = new ArrayList<>();

        db = helper.getReadableDatabase();

        try(Cursor cursor = db.query(TABLE_NAME,
                PROJECTION,
                null,
                null,
                null,
                null,
                null)){
            int indexId = cursor.getColumnIndex(_ID);
            int indexName = cursor.getColumnIndex(NAME);
            int indexTel = cursor.getColumnIndex(TEL);

            while (cursor.moveToNext()){
                Shop shop = new Shop();
                shop.setId(cursor.getInt(indexId));
                shop.setName(cursor.getString(indexName));
                shop.setTel(cursor.getInt(indexTel));

                shops.add(shop);
            }
        }

        db.close();
        return shops;
    }
}
