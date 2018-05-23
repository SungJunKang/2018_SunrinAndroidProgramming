package com.example.test11;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ListView detail_list;
    String city;
    ArrayList<String> datas;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_list = findViewById(R.id.detail_list);

        Intent intent = getIntent();
        city = intent.getExtras().getString("city");

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select location from tb_data where category='" + city + "'", null);
        datas = new ArrayList<>();

        while(cursor.moveToNext()){
            datas.add(cursor.getString(0));
        }

        db.close();

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        detail_list.setAdapter(arrayAdapter);

        detail_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("city", city);
                intent.putExtra("city_detail", datas.get(i));

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
