package com.example.myinternal;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText content;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.content);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
            try{
                // 외부 저장 공간 폴더 만들기
                String dirPath = getFilesDir() + "/myTest";
                File dir = new File(dirPath);
                // 폴더가 없다면
                if(!dir.exists()){
                    dir.mkdir();
                }

                // 파일 만들기
                File file = new File(dir + "/test.txt");
                // 파일이 없다면
                if(!file.exists()){
                    file.createNewFile();
                }

                //파일 저장
                FileWriter writer = new FileWriter(file, true);
                writer.write(content.getText().toString());
                writer.flush();
                writer.close();

                // 결과 확인을 위한 ReadActivity 호출
                Intent intent = new Intent(this, ReadFileActivity.class);
                startActivity(intent);
            }catch (IOException e){
                Log.e("MainActivity", "파일이 존재하지 않습니다.");
            }
    }
}
