package com.example.sunrin.a20180402;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_vib, btn_sys, btn_cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_vib = findViewById(R.id.btn_vib);
        btn_sys = findViewById(R.id.btn_sys);
        btn_cus = findViewById(R.id.btn_cus);

        btn_vib.setOnClickListener(this);
        btn_sys.setOnClickListener(this);
        btn_cus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.btn_vib:
                // 진동
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
                break;

            case R.id.btn_sys:
                // 시스템 효과음
                Uri myUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), myUri);
                ringtone.play();
                break;

            case R.id.btn_cus:
                // 임의의 벨소리
                MediaPlayer player = MediaPlayer.create(this, R.raw.fallbackring);
                player.start();
                break;

            default:
                break;
        }
    }
}
