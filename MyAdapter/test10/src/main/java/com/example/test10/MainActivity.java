package com.example.test10;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Boolean callPermission = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.custon_list);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED){
            callPermission = true;
        }

        if(!callPermission){
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.CALL_PHONE},
                    100);
        }

        // data 불러오기
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_calllog", null);

        ArrayList<Person> datas = new ArrayList<>();

        while(cursor.moveToNext()){
            Person person = new Person();
            person.name = cursor.getString(1);
            person.photo = cursor.getString(2);
            person.date = cursor.getString(3);
            person.phone = cursor.getString(4);
            datas.add(person);
        }

        // Custom Adapter 생성
        PersonAdapter personAdapter = new PersonAdapter(this,
                R.layout.custom_item, datas);

        // ListView에 Adapter 설정
        listView.setAdapter(personAdapter);
    }
}
