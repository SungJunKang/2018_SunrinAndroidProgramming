package com.example.sunrin.myadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=7;

    public DBHelper(Context context){
        super(context, "datadb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SimpleAdapter, CursorAdapter Test.........
        String tableSql="create table tb_data ("+
                "_id integer primary key autoincrement," +
                "name not null," +
                "content)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_data (name, content) values ('3학년4반','3학년 4반은 화,목요일 수업입니다.')");
        db.execSQL("insert into tb_data (name, content) values ('3학년5반','3학년 5반은 월,수요일 수업입니다.')");


        String driverTable="create table tb_drive ("+
                "_id integer primary key autoincrement," +
                "title," +
                "date," +
                "type)";
        db.execSQL(driverTable);
        db.execSQL("insert into tb_drive (title, date, type) values ('안드로이드','최종 수정 날짜 : 2월 6일', 'doc')");
        db.execSQL("insert into tb_drive (title, date, type) values ('db.zip','최종 수정 날짜 : 1월 16일', 'file')");
        db.execSQL("insert into tb_drive (title, date, type) values ('하이브리드','최종 수정 날짜 : 1월 8일', 'doc')");
        db.execSQL("insert into tb_drive (title, date, type) values ('이미지1','최종 수정 날짜 : 1월 1일', 'img')");
        db.execSQL("insert into tb_drive (title, date, type) values ('Part4','최종 수정 날짜 : 12월 24일', 'file')");
        db.execSQL("insert into tb_drive (title, date, type) values ('Angular','최종 수정 날짜 : 12월 6일', 'doc')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_data");
            db.execSQL("drop table tb_drive");
            onCreate(db);
        }
    }
}
