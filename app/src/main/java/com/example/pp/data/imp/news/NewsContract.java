package com.example.pp.data.imp.news;

import android.provider.BaseColumns;

public class NewsContract {

    private NewsContract() {
    }

    public final static String TABLE_NAME = "news";

    public final static String _ID = BaseColumns._ID;
    public final static String TITLE = "title";
    public final static String TEXT = "text";
    public final static String DATE = "date";

    public static String SQL_CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TITLE + " TEXT NOT NULL DEFAULT 0, "
            + TEXT + " TEXT NOT NULL DEFAULT 0, "
            + DATE + " LONG NOT NULL DEFAULT 0);";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static String[] PROJECTION = {
            _ID,
            TITLE,
            TEXT,
            DATE};
}
