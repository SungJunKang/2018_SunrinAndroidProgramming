package com.example.sunrin.myresource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView text1;
    Animation flowAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load animation
        flowAnim = AnimationUtils.loadAnimation(this, R.anim.flow);

        btn1 = findViewById(R.id.btn1);
        text1 = findViewById(R.id.text1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start animation
                text1.startAnimation(flowAnim);
            }
        });
    }
}
