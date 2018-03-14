package com.example.mywidget;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "HMFMPYUN.TTF");

        text.setTypeface(typeface);
    }
}
