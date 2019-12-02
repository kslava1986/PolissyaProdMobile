package com.example.pp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.pp.data.ShopContract.*;

import androidx.annotation.Nullable;

public class ShopDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shoplist.db";
    public static final int DATABASE_VERSION = 3;

    public ShopDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ShopEntry.SQL_CREATE_SHOPLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ShopEntry.SQL_DROP_SHOPLIST_TABLE);
        onCreate(db);
    }

}
