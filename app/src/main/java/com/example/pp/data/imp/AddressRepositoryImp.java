package com.example.pp.data.imp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pp.data.AddressRepositoryLite;
import com.example.pp.data.AppDBHelper;
import com.example.pp.model.shop.Address;

import static com.example.pp.data.imp.address.AddressContract.*;

public class AddressRepositoryImp implements AddressRepositoryLite {
    private AppDBHelper helper;
    private SQLiteDatabase db;

    public AddressRepositoryImp(Context context) {
        this.helper = new AppDBHelper(context);
    }

    @Override
    public void save(Address address) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, address.getName());
        values.put(NUMBER, address.getNumber());
        values.put(ID_SHOP, address.getIdShop());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void update(Address address) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, address.getName());
        values.put(NUMBER, address.getNumber());

        db.update(TABLE_NAME, values, ID_SHOP,
                new String[]{String.valueOf(address.getIdShop())});

        db.close();
    }

    @Override
    public void delete(Address address) {
        db = helper.getWritableDatabase();

        db.delete(TABLE_NAME, ID_SHOP, new String[]{String.valueOf(address.getIdShop())});

        db.close();
    }

    @Override
    public Address get(int idShop) {
        db = helper.getReadableDatabase();

        try (Cursor cursor = db.query(TABLE_NAME,
                PROJECTION,
                ID_SHOP,
                new String[]{String.valueOf(idShop)},
                null,
                null,
                null)) {
            int indexName = cursor.getColumnIndex(NAME);
            int indexIndex = cursor.getColumnIndex(NUMBER);

            if (cursor.moveToNext()) {
                Address address = new Address();
                address.setName(cursor.getString(indexName));
                address.setNumber(cursor.getInt(indexIndex));
                address.setIdShop(idShop);

                db.close();
                return address;
            }

            db.close();
            return null;
        }
    }
}
