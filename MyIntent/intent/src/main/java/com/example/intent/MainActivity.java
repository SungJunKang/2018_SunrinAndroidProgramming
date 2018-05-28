package com.example.intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
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

        resultView = findViewById(R.id.resultView);
        contactsBtn = findViewById(R.id.btn_contacts);
        cameraDataBtn = findViewById(R.id.btn_camera_data);
        cameraFileBtn = findViewById(R.id.btn_camera_file);
        speechBtn = findViewById(R.id.btn_speech);
        mapBtn = findViewById(R.id.btn_map);
        browserBtn = findViewById(R.id.btn_browser);
        callBtn = findViewById(R.id.btn_call);
        resultImageView = findViewById(R.id.resultImageView);
        galleryBtn = findViewById(R.id.btn_gallery);

        contactsBtn.setOnClickListener(this);
        cameraDataBtn.setOnClickListener(this);
        cameraFileBtn.setOnClickListener(this);
        speechBtn.setOnClickListener(this);
        mapBtn.setOnClickListener(this);
        browserBtn.setOnClickListener(this);
        callBtn.setOnClickListener(this);
        resultImageView.setOnClickListener(this);
        galleryBtn.setOnClickListener(this);

        // reqWidth = getResources().getDimensionPixelSize(R.dimen.request_image_width);
        // reqHeight = getResources().getDimensionPixelSize(R.dimen.request_image_height);
    }

    @Override
    public void onClick(View v) {
        if(v == contactsBtn){
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setData(ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, 10);
        }

        else if(v == cameraDataBtn){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 30);
        }

        else if(v == resultImageView){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri photoUri = FileProvider.getUriForFile(this,
                    BuildConfig.APPLICATION_ID + ".provider", filePath);
            intent.setDataAndType(photoUri, "image/*");
            intent.addFlags(intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);
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
    }
}
