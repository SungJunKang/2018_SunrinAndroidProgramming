package com.example.sunrin.a20180416_homework;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText add_title, add_singer, add_content;
    Button add_btn, search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_title = findViewById(R.id.add_title);
        add_singer = findViewById(R.id.add_singer);
        add_content = findViewById(R.id.add_content);
        add_btn = findViewById(R.id.add_btn);
        search_btn = findViewById(R.id.search_btn);

        add_btn.setOnClickListener(this);
        search_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == add_btn){
            String title = add_title.getText().toString();
            String singer = add_singer.getText().toString();
            String content = add_content.getText().toString();

            // DB Open
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            // Insert SQL
            String insertSQL = "insert into " + helper.TABLE_NAME +
                    " (title, singer, content) values ('" + title + "', '" + singer + "', '" + content + "');";

            // Insert 실행
            db.execSQL(insertSQL);
            db.close();

            Toast.makeText(this, "저장이 완료되었습니다.", Toast.LENGTH_SHORT).show();

            add_title.setText("");
            add_singer.setText("");
            add_content.setText("");
        }
        else if(view == search_btn){
            // 검색 화면 호출
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }
    }
}
