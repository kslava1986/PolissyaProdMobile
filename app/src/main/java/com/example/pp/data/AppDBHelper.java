package com.example.pp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pp.data.imp.address.AddressContract;
import com.example.pp.data.imp.setting.SettingContract;
import com.example.pp.data.imp.worktime.WorkTimeContract;
import com.example.pp.data.imp.shop.ShopContract;

import androidx.annotation.Nullable;

public class AppDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "polissya.db";
    private static final int DATABASE_VERSION = 6;

    public AppDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SettingContract.SQL_CREATE_TABLE);
        db.execSQL(AddressContract.SQL_CREATE_TABLE);
        db.execSQL(WorkTimeContract.SQL_CREATE_TABLE);
        db.execSQL(ShopContract.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SettingContract.SQL_DROP_TABLE);
        db.execSQL(AddressContract.SQL_DROP_TABLE);
        db.execSQL(WorkTimeContract.SQL_DROP_TABLE);
        db.execSQL(ShopContract.SQL_DROP_TABLE);

        onCreate(db);
    }
}
