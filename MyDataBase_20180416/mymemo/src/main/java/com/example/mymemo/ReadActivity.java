package com.example.mymemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {

    TextView read_title, read_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        read_title = findViewById(R.id.read_title);
        read_content = findViewById(R.id.read_content);

        // DB Open
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        // SelectSQL로 Record 조회
        String selectSQL = "select * from " + helper.TABLE_NAME +
                " order by _id desc limit 1;";
        Cursor cursor = db.rawQuery(selectSQL, null);
        cursor.moveToNext();

        // textView에 결과 넣기
        read_title.setText(cursor.getString(1));
        read_content.setText(cursor.getString(2));

        db.close();
    }
}
