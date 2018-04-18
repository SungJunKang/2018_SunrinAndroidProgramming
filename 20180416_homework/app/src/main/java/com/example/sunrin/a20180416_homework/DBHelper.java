package com.example.sunrin.a20180416_homework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "db_song";
    public static String TABLE_NAME = "tb_song";
    public static int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableSQL = "create table " + TABLE_NAME + "(_id integer primary key autoincrement, title text, singer text, content text); ";
        sqLiteDatabase.execSQL(tableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" drop table " + TABLE_NAME + ";");
        onCreate(sqLiteDatabase);
    }
}
