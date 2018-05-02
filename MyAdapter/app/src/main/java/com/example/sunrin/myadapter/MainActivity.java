package com.example.sunrin.myadapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView, simpleListView, cursorListView;
    String[] datas = {"서울특별시", "경기도", "인천광역시", "부산광역시"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        simpleListView = findViewById(R.id.simple_list);
        cursorListView = findViewById(R.id.cursor_list);

        // ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, datas);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        // SimpleAdapter
        ArrayList<HashMap<String, String>> simpleDatas = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "강성준");
        map.put("message", "안녕하세요, 3학년 5반 강성준입니다.");
        simpleDatas.add(map);
        map = new HashMap<>();
        map.put("name", "강철수");
        map.put("message", "안녕하세요, 3학년 5반 강철수입니다.");
        simpleDatas.add(map);

        // SimpleAdapter 생성
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, simpleDatas,
                android.R.layout.simple_list_item_2, new String[]{"name", "message"},
                new int[]{android.R.id.text1, android.R.id.text2});
        // ListView 에 adapter setting
        simpleListView.setAdapter(simpleAdapter);

        // CursorAdapter
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_data", null);

        // CursorAdapter 생성
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, cursor, new String[]{"name", "content"},
                new int[]{android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        // ListView 에 adapter setting
        cursorListView.setAdapter(simpleCursorAdapter);
        db.close();
}

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Toast.makeText(this, datas[index], Toast.LENGTH_SHORT).show();
    }
}
