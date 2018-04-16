package com.example.sunrin.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    EditText et1, et2;
    TextView text;
    String databaseName, tableName;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        text = findViewById(R.id.text);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DB 생성 또는 오픈
                databaseName = et1.getText().toString();
                createDatabase(databaseName);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Table 생성
                tableName = et2.getText().toString();
                createTable(tableName);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Record 삽입
                insertRecord();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Record 조회
                selectRecord();
            }
        });
    }

    private void createDatabase(String name){
        db = openOrCreateDatabase(name, MODE_ENABLE_WRITE_AHEAD_LOGGING, null);
        text.append(name + " database created!! \n");
    }

    private void createTable(String name){
        String createSQL = "create table if not exists " + name + " (" +
                "_id integer primary key autoincrement, " +
                "name text, " +
                "age integer, " +
                "phone text); ";
        db.execSQL(createSQL);
        text.append(name + " table created!! \n");
    }

    private void insertRecord(){
        db.execSQL("insert into " + tableName + "(name, age, phone) values ('John', 20, '010-1234-5678');");
        db.execSQL("insert into " + tableName + "(name, age, phone) values ('Mike', 35, '010-9876-5432');");
        db.execSQL("insert into " + tableName + "(name, age, phone) values ('Sean', 26, '010-9999-8888');");

        text.append("record inserted!!! \n");
    }

    private void selectRecord(){
        String selectSQL = "select * from " + tableName;
        Cursor cursor = db.rawQuery(selectSQL, null);

        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToNext();
            text.append(cursor.getString(1) + ", " + cursor.getInt(2) + ", " + cursor.getString(3) + "\n");
        }
    }
}
