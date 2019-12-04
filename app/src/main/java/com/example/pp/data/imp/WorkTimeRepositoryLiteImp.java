package com.example.pp.data.imp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pp.data.AppDBHelper;
import com.example.pp.data.WorkTimeRepositoryLite;
import com.example.pp.model.shop.WorkTime;

import static com.example.pp.data.imp.worktime.WorkTimeContract.*;

public class WorkTimeRepositoryLiteImp implements WorkTimeRepositoryLite {
    private AppDBHelper helper;
    private SQLiteDatabase db;

    public WorkTimeRepositoryLiteImp(Context context) {
        this.helper = new AppDBHelper(context);
    }

    @Override
    public void save(WorkTime workTime) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(START_HOUR, workTime.getStartHour());
        values.put(START_MINUTE, workTime.getStartMinute());
        values.put(END_HOUR, workTime.getEndHour());
        values.put(END_MINUTE, workTime.getEndMinute());
        values.put(ID_SHOP, workTime.getIdShop());

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @Override
    public void delete(WorkTime workTime) {
        db = helper.getWritableDatabase();

        db.delete(TABLE_NAME, ID_SHOP, new String[]{String.valueOf(workTime.getIdShop())});

        db.close();
    }

    @Override
    public void update(WorkTime workTime) {
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(START_HOUR, workTime.getStartHour());
        values.put(START_MINUTE, workTime.getStartMinute());
        values.put(END_HOUR, workTime.getEndHour());
        values.put(END_MINUTE, workTime.getEndMinute());

        db.update(TABLE_NAME, values, ID_SHOP,
                new String[]{String.valueOf(workTime.getIdShop())});

        db.close();
    }

    @Override
    public WorkTime get(int idShop) {
        db = helper.getReadableDatabase();

        try (Cursor cursor = db.query(TABLE_NAME,
                PROJECTION,
                ID_SHOP,
                new String[]{String.valueOf(idShop)},
                null,
                null,
                null)) {
            int indexStartHour = cursor.getColumnIndex(START_HOUR);
            int indexStartMinute = cursor.getColumnIndex(START_MINUTE);
            int indexEndHour = cursor.getColumnIndex(END_HOUR);
            int indexEndMinute = cursor.getColumnIndex(END_MINUTE);

            if (cursor.moveToNext()) {
                WorkTime workTime = new WorkTime();
                workTime.setStartHour(cursor.getInt(indexStartHour));
                workTime.setStartMinute(cursor.getInt(indexStartMinute));
                workTime.setEndHour(cursor.getInt(indexEndHour));
                workTime.setEndMinute(cursor.getInt(indexEndMinute));
                workTime.setIdShop(idShop);

                db.close();
                return workTime;
            }

            db.close();
            return null;
        }
    }
}
