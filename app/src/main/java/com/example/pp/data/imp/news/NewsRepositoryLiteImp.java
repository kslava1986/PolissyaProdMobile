package com.example.pp.data.imp.news;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pp.data.AppDBHelper;
import com.example.pp.data.NewsRepositoryLite;
import com.example.pp.model.news.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.pp.data.imp.news.NewsContract.*;

public class NewsRepositoryLiteImp implements NewsRepositoryLite {
    private AppDBHelper helper;
    private SQLiteDatabase db;

    public NewsRepositoryLiteImp(Context context) {
        this.helper = new AppDBHelper(context);
    }

    @Override
    public void save(News news) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, news.getTitle());
        values.put(TEXT, news.getText());
        values.put(DATE, news.getDate().getTime());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void delete(int id) {
        db = helper.getWritableDatabase();

        db.delete(TABLE_NAME, _ID, new String[]{String.valueOf(id)});

        db.close();
    }

    @Override
    public News get(int id) {
        db = helper.getReadableDatabase();

        try(Cursor cursor = db.query(TABLE_NAME,
                PROJECTION,
                null,
                null,
                null,
                null,
                null)){
            int indexId = cursor.getColumnIndex(_ID);
            int indexTitle = cursor.getColumnIndex(TITLE);
            int indexText = cursor.getColumnIndex(TEXT);
            int indexDate = cursor.getColumnIndex(DATE);

            while (cursor.moveToNext()){

                int currentId = cursor.getInt(indexId);
                if(currentId == id){
                    News news = new News();
                    news.setId(currentId);
                    news.setTitle(cursor.getString(indexTitle));
                    news.setText(cursor.getString(indexText));
                    news.setDate(new Date(cursor.getLong(indexDate)));

                    db.close();
                    return news;
                }
            }
        }

        db.close();
        return null;
    }

    @Override
    public void update(News news) {
        if(news.getId() != null){
            db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(TITLE, news.getTitle());
            values.put(TEXT, news.getText());
            values.put(DATE, news.getDate().getTime());

            db.update(TABLE_NAME, values, _ID, new String[]{String.valueOf(news.getId())});

            db.close();
        }
    }

    @Override
    public List<News> getAll() {
        List<News> list = new ArrayList<>();

        db = helper.getReadableDatabase();

        try (Cursor cursor = db.query(TABLE_NAME,
                PROJECTION,
                null,
                null,
                null,
                null,
                null)) {
            int indexId = cursor.getColumnIndex(_ID);
            int indexTitle = cursor.getColumnIndex(TITLE);
            int indexText = cursor.getColumnIndex(TEXT);
            int indexDate = cursor.getColumnIndex(DATE);

            while (cursor.moveToNext()) {
                News news = new News();
                news.setId(cursor.getInt(indexId));
                news.setTitle(cursor.getString(indexTitle));
                news.setText(cursor.getString(indexText));
                news.setDate(new Date(cursor.getLong(indexDate)));

                list.add(news);
            }
        }

        db.close();
        return list;
    }
}
