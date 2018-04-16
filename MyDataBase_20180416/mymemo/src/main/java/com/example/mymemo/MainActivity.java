package com.example.mymemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText add_title, add_content;
    Button add_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_title = findViewById(R.id.add_title);
        add_content = findViewById(R.id.add_content);
        add_btn = findViewById(R.id.add_btn);

        add_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String title = add_title.getText().toString();
        String content = add_content.getText().toString();

        // DB Open
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        // Insert SQL
        String insertSQL = "insert into " + helper.TABLE_NAME +
                " (title, content) values ('" + title + "', '" + content + "');";

        // Insert 실행
        db.execSQL(insertSQL);
        db.close();

        // 조회 화면 호출
        Intent intent = new Intent(this, ReadActivity.class);
        startActivity(intent);
    }
}
