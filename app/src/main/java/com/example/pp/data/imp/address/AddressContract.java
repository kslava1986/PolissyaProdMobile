package com.example.pp.data.imp.address;

import android.provider.BaseColumns;

public class AddressContract {
    private AddressContract() {
    }

    public final static String TABLE_NAME = "address";

    public final static String _ID = BaseColumns._ID;
    public final static String NAME = "name";
    public final static String NUMBER = "number";
    public final static String ID_SHOP = "id_shop";

    public static String SQL_CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " TEXT NOT NULL DEFAULT 0, "
            + NUMBER + " INTEGER NOT NULL DEFAULT 0, "
            + ID_SHOP + " INTEGER NOT NULL DEFAULT 0);";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static String[] PROJECTION = {
            _ID,
            NAME,
            NUMBER,
            ID_SHOP};
}
