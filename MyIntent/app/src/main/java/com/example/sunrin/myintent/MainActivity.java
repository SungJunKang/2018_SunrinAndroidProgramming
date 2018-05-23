package com.example.sunrin.myintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView_name);
    }

    public void onButtonClicked(View v){
        // 수정
        Intent intent = new Intent();
        intent.setAction("com.example.sunrin.myintent.ACTION_VIEW");
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Toast.makeText(this, "onActivityResult 메소드 호출됨.", Toast.LENGTH_SHORT).show();
            if(resultCode == RESULT_OK){
                String name = data.getExtras().getString("name");
                textView.setText(name + "님 환영합니다!");
            }
        }
    }
}
