package com.example.sunrin.a20180328_homework;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView korea, china, start, arrive, people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        korea = findViewById(R.id.korea);
        china = findViewById(R.id.china);
        start = findViewById(R.id.start);
        arrive = findViewById(R.id.arrive);
        people = findViewById(R.id.people);

        korea.setOnClickListener(this);
        china.setOnClickListener(this);
        start.setOnClickListener(this);
        arrive.setOnClickListener(this);
        people.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == korea){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("한국 도시 선택");
            builder.setSingleChoiceItems(R.array.city, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String[] datas = getResources().getStringArray(R.array.city);
                    korea.setText(datas[i]);
                }
            });
            builder.setNegativeButton("닫기", null);

            AlertDialog kocityDialog = builder.create();
            kocityDialog.show();
        }

        else if(view == china){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("중국 도시 선택");
            builder.setSingleChoiceItems(R.array.city2, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String[] datas = getResources().getStringArray(R.array.city2);
                    china.setText(datas[i]);
                }
            });
            builder.setNegativeButton("닫기", null);

            AlertDialog chcityDialog = builder.create();
            chcityDialog.show();
        }

        else if(view == start){
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    start.setText(i + "." + (i1 + 1) + "." + i2);
                }
            }, year, month, day);

            datePickerDialog.show();
        }

        else if(view == arrive){
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    arrive.setText(i + "." + (i1 + 1) + "." + i2);
                }
            }, year, month, day);

            datePickerDialog.show();
        }

        else if(view == people){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.custom_dialog, null);

            builder.setView(v);

            final EditText et1 = v.findViewById(R.id.num1);
            final EditText et2 = v.findViewById(R.id.num2);
            final EditText et3 = v.findViewById(R.id.num3);

            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String s1 = et1.getText().toString();
                    String s2 = et2.getText().toString();
                    String s3 = et3.getText().toString();

                    people.setText("성인 " + s1 + ", 소아 " + s2 + ", 유아 " + s3);
                }
            });

            AlertDialog customDialog = builder.create();
            customDialog.show();
        }
    }
}
