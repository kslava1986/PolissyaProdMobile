package com.example.pp.data.imp.shop;

import android.provider.BaseColumns;

public class ShopContract {
    private ShopContract() {
    }

    public final static String TABLE_NAME = "shop";

    public final static String _ID = BaseColumns._ID;
    public final static String NAME = "name";
    public final static String TEL = "tel";

    public static String SQL_CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " TEXT NOT NULL DEFAULT 0, "
            + TEL + " INTEGER NOT NULL DEFAULT 0);";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static String[] PROJECTION = {
            _ID,
            NAME,
            TEL};
}
