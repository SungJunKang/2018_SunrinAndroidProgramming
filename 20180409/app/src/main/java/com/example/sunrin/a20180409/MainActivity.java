package com.example.sunrin.a20180409;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "방향 : ORIENTATION_PORTRAIT", Toast.LENGTH_SHORT).show();
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "방향 : ORIENTATION_LANDSCAPE", Toast.LENGTH_SHORT).show();
        }
    }
}
