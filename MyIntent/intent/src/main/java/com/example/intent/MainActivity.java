package com.example.intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.TintContextWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button contactsBtn;
    Button cameraDataBtn;
    Button cameraFileBtn;
    Button speechBtn;
    Button mapBtn;
    Button browserBtn;
    Button callBtn;
    Button galleryBtn;

    TextView resultView;
    ImageView resultImageView;

    File filePath;

    int reqWidth;
    int reqHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    @Override
    public void onClick(View v) {
        else if(v == mapBtn){
            // 지도 연동
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:37.5662952, 126.9779451?q=37.5662952, 126.9779451"));
            startActivity(intent);
        }

        else if(v == browserBtn){
            // 브라우저
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.seoul.go.kr"));
            startActivity(intent);
        }

        else if(v == callBtn){
            // 전화 걸기, 권한 필요
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE) ==
                    PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1234-5678"));
                startActivity(intent);
            }

            else{
                // 권한 요청
                ActivityCompat.requestPermissions(this, new String[]
                        { Manifest.permission.CALL_PHONE }, 100);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 10 && resultCode == RESULT_OK){
            String result = data.getDataString();
            resultView.setText(result);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(ContactsContract.Contacts.CONTENT_URI + "/" + 1));
            startActivity(intent);
        }

        else if(requestCode == 30 && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            resultImageView.setImageBitmap(bitmap);
        }

        else if(requestCode == 40 && resultCode == RESULT_OK){
            Bitmap bitmap = BitmapFactory.decodeFile(filePath.getAbsolutePath());
            resultImageView.setImageBitmap(bitmap);
        }

        else if(requestCode == 50 && resultCode == RESULT_OK){
            // 음성인식 결과 보여주기
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String result = results.get(0);
            resultView.setText(result);
        }
    }
}
