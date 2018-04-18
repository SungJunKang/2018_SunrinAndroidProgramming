package com.example.sunrin.a20180416_homework;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    TextView read_title, read_singer, read_content;
    EditText et_search;
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        read_title = findViewById(R.id.read_title);
        read_singer = findViewById(R.id.read_singer);
        read_content = findViewById(R.id.read_content);
        et_search = findViewById(R.id.et_search);
        btn_search = findViewById(R.id.btn_search);

        btn_search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try{
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getReadableDatabase();

            String searchSQL = "select * from " + helper.TABLE_NAME +
                    " where title='" + et_search.getText().toString() + "'; ";
            Cursor cursor = db.rawQuery(searchSQL, null);
            cursor.moveToNext();

            read_title.setText(cursor.getString(1));
            read_singer.setText(cursor.getString(2));
            read_content.setText(cursor.getString(3));

            db.close();
        }catch (Exception e){
            Toast.makeText(this, "내용을 찾을 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
