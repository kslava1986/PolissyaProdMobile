package com.example.pp.data.imp.worktime;

import android.provider.BaseColumns;

public class WorkTimeContract {
    private WorkTimeContract() {
    }

    public final static String TABLE_NAME = "worktime";

    public final static String _ID = BaseColumns._ID;
    public final static String START_HOUR = "start_hour";
    public final static String START_MINUTE = "start_minute";
    public final static String END_HOUR = "end_hour";
    public final static String END_MINUTE = "end_minute";
    public final static String ID_SHOP = "id_shop";

    public static String SQL_CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + START_HOUR + " INTEGER NOT NULL DEFAULT 0, "
            + START_MINUTE + " INTEGER NOT NULL DEFAULT 0, "
            + END_HOUR + " INTEGER NOT NULL DEFAULT 0, "
            + END_MINUTE + " INTEGER NOT NULL DEFAULT 0, "
            + ID_SHOP + " INTEGER NOT NULL DEFAULT 0);";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static String[] PROJECTION = {
            _ID,
            START_HOUR,
            START_MINUTE,
            END_HOUR,
            END_MINUTE,
            ID_SHOP};
}
