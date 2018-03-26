
package com.example.mydialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2;
    String item[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btn1){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("알림");
            builder.setMessage("정말 종료하시겠습니까?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    showToast("alert dialog OK click...");
                }
            });
            builder.setNegativeButton("NO", null);
            builder.setCancelable(false);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        else if(view == btn2){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("입장권 판매");
            item = new String[]{"어른", "청소년", "어린이"};
            builder.setItems(item, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    showToast(item[i]+ "이(가) 선택되었습니다.");
                }
            });
            builder.setNegativeButton("취소", null);
            builder.setCancelable(false);

            AlertDialog listDialog = builder.create();
            listDialog.show();
        }
    }

    public void showToast(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}