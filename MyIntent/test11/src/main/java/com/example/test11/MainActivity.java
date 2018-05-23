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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView main_list;
    ArrayList<String> datas;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_list = findViewById(R.id.main_list);

        DBHelper helper= new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select location from tb_data where category='0'", null);

        datas = new ArrayList<>();
        while(cursor.moveToNext()){
            datas.add(cursor.getString(0));
        }

        db.close();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        main_list.setAdapter(adapter);

        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();

                intent.putExtra("city", datas.get(i));
                setResult(RESULT_OK, intent);
                intent.setAction("com.example.test11.ACTION_VIEW");
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String city = data.getExtras().getString("city");
            String city_detail = data.getExtras().getString("city_detail");

            Toast.makeText(this, city + " " + city_detail, Toast.LENGTH_SHORT).show();
        }
    }
}
