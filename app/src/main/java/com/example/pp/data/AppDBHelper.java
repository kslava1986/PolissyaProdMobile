package com.example.pp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pp.data.imp.setting.SettingContract;

import androidx.annotation.Nullable;

public class AppDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "polissya.db";
    private static final int DATABASE_VERSION = 1;

    public AppDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SettingContract.SQL_CREATE_TABLE_SETTING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SettingContract.SQL_DROP_TABLE_SETTING);
        onCreate(db);
    }
}
