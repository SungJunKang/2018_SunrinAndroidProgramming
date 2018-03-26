package com.example.mydialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_x, edit_y;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_x = findViewById(R.id.edit_x);
        edit_y = findViewById(R.id.edit_y);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast 객체 생성
                Toast toast = Toast.makeText(getApplicationContext(), "Hello World!", Toast.LENGTH_SHORT);

                // 입력된 x, y offset 값 가져오기
                int xOffset = Integer.valueOf(edit_x.getText().toString());
                int yOffset = Integer.valueOf(edit_y.getText().toString());

                // 토스트가 보일 위치 지정
                toast.setGravity(Gravity.CENTER, xOffset, yOffset);

                // 토스트 보이기
                toast.show();
            }
        });
    }
}
