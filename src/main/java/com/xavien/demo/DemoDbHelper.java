package com.xavien.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavien on 2015/4/6.
 */
public class DemoDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Demo.db";

    public DemoDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DemoDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + DemoEntry.TABLE_NAME + " ("
                + DemoEntry._ID + " INTEGER PRIMARY KEY,"
                + DemoEntry.COLUMN_NAME_TITLE + " TEXT"
                + ")";
        db.execSQL(sql);
    }

    public void insert(String title){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues(1);
        cv.put(DemoEntry.COLUMN_NAME_TITLE, title);
        db.insert(DemoEntry.TABLE_NAME, null, cv);
        db.close();
    }

    public List<String> queryAll(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + DemoEntry.TABLE_NAME + " ORDER BY " + DemoEntry._ID;
        Cursor cursor = db.rawQuery(sql, null);
        List<String> recordList = new ArrayList<String>();

        if(cursor.moveToFirst()){
            int title_id = cursor.getColumnIndex(DemoEntry.COLUMN_NAME_TITLE);
            do{
                recordList.add(cursor.getString(title_id));
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public abstract class DemoEntry implements BaseColumns{

        public static final String TABLE_NAME = "demo";
        public static final String COLUMN_NAME_TITLE = "title";

    }
}
