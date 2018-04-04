package com.example.test7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1, btn2, btn3, btn4;
    Animation alpha, rotate, scale, translate;
    Animation anim;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        imgView = findViewById(R.id.imageView);

        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        translate = AnimationUtils.loadAnimation(this, R.anim.translate);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == btn1){
            imgView.startAnimation(translate);
            translate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    Toast.makeText(getApplicationContext(), "종료됨.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        }
        else if(view == btn2){
            imgView.startAnimation(rotate);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    Toast.makeText(getApplicationContext(), "종료됨.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        }
        else if(view == btn3){
            imgView.startAnimation(scale);
            scale.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    Toast.makeText(getApplicationContext(), "종료됨.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        }
        else if(view == btn4){
            imgView.startAnimation(alpha);
            alpha.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    Toast.makeText(getApplicationContext(), "종료됨.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        }
    }
}
