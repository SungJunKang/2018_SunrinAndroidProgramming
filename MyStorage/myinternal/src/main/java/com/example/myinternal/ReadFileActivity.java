package com.example.myinternal;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        result = findViewById(R.id.fileResult);

        File file = new File(getFilesDir() + "/myTest/test.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuffer buffer = new StringBuffer();
            String line;

            // 경로를 버퍼에 저장
            buffer.append(file.getAbsolutePath().toString() + "\n");

            // 파일 내용을 버퍼에 저장
            while((line = reader.readLine()) != null){
                buffer.append(line + "\n");
            }

            // 버퍼 내용을 TextView에 출력
            result.setText(buffer.toString());

            reader.close();
        } catch (IOException e) {
            Log.e("ReadFileActivity", "파일 읽기 오류입니다.");
        }
    }
}
