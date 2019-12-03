package com.example.pp.data.imp.setting;

import android.provider.BaseColumns;

public class SettingContract {
    private SettingContract() {
    }

    public final static String TABLE_NAME = "setting";

    public final static String _ID = BaseColumns._ID;
    public final static String KEY = "key";
    public final static String VALUE = "value";

    public static String SQL_CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY + " TEXT NOT NULL DEFAULT 0, "
            + VALUE + " TEXT NOT NULL DEFAULT 0);";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static String[] PROJECTION = {
            _ID,
            KEY,
            VALUE};
}


