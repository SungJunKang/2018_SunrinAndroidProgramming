package com.example.sunrin.myactivity;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button toggleBtn, pictureBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleBtn = findViewById(R.id.toggleBtn);
        pictureBtn = findViewById(R.id.pictureBtn);

        toggleBtn.setOnClickListener(this);
        pictureBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        // 키보드 제어
        if(v == toggleBtn){
            InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            manager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_NOT_ALWAYS);
        }
        // PictureInPicture
        else if(v == pictureBtn){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                PictureInPictureParams.Builder pipBuilder = new PictureInPictureParams.Builder();
                enterPictureInPictureMode(pipBuilder.build());
            }
        }
    }

    // 멀티윈도우 api24 추가 기능
    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        showToast("멀티 윈도우 모드 ");
    }

    // 실행 상태
    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume.... 포커스!!");
    }

    // 일시 정지 상태
    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause.... 일시정지!!");
    }

    // 화면 전환
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            showToast("세로 방향...");
        }
        else{
            showToast("가로 방향...");
        }
    }

    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
