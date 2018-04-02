package com.example.myevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.text);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });
    }

    float curX;
    float curY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN){
            curX = event.getRawX();
        }
//        else if(action == MotionEvent.ACTION_MOVE){
//            println("손가락 움직임 : " + curX + ", " + curY);
//        }
        else if(action == MotionEvent.ACTION_UP){
            float diffX = curX - event.getRawX();
            if(diffX > 30){
                println("왼쪽으로 화면을 밀었습니다.");
            }
            else if(diffX < -30){
                println("오른쪽으로 화면을 밀었습니다.");
            }
        }

        return true;
    }

    public void println(String s){
        text.append(s + "\n");
    }
}
