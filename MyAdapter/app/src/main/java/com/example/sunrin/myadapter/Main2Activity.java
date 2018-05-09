package com.example.sunrin.myadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.custom_List);

        // data 불러오기
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_drive", null);

        ArrayList<Drive> datas = new ArrayList<>();

        while(cursor.moveToNext()){
            Drive drive = new Drive();
            drive.title = cursor.getString(1);
            drive.date = cursor.getString(2);
            drive.type = cursor.getString(3);
            datas.add(drive);
        }

        // Custom Adapter 생성
        DriveAdapter driveAdapter = new DriveAdapter(this,
                R.layout.custom_item, datas);

        // ListView에 Adapter 설정
        listView.setAdapter(driveAdapter);
    }
}
