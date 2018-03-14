package com.example.sunrin.a20180314;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Frame2Activity extends AppCompatActivity {

    ImageView img1;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame2);

        img1 = (ImageView)findViewById(R.id.img1);
        img2 = (ImageView)findViewById(R.id.img2);
    }

    public void onImage1Clicked(View v){
        v.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.VISIBLE);
    }

    public void onImage2Clicked(View v){
        v.setVisibility(View.INVISIBLE);
        img1.setVisibility(View.VISIBLE);
    }
}
