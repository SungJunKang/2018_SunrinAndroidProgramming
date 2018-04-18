package com.example.sunrin.mystorage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    boolean fileReadPermission, fileWritePermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.content);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);

        // 퍼미션 체크
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            fileReadPermission = true;
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            fileWritePermission = true;
        }

        // 퍼미션이 없으면 퍼미션 요청
        if (!fileReadPermission || !fileWritePermission) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    100);
        }
    }

    // 사용자 응답 결과에 따른 처리
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100 && grantResults.length > 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                fileReadPermission = true;
            }
            if(grantResults[1] == PackageManager.PERMISSION_GRANTED){
                fileWritePermission = true;
            }
        }
    }

    @Override
    public void onClick(View view) {
        // 퍼미션이 부여되어 있다면
        if(fileReadPermission && fileWritePermission){
            try{
                // 외부 저장 공간 폴더 만들기
                String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myApp";
                File dir = new File(dirPath);
                // 폴더가 없다면
                if(!dir.exists()){
                    dir.mkdir();
                }

                // 파일 만들기
                File file = new File(dir + "/myFile.txt");
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
        else{
            Toast.makeText(this, "퍼미션이 없어 실행할 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
