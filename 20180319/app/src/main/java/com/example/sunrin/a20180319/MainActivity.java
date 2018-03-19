package com.example.sunrin.a20180319;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText message;
    TextView text, text_size;
    Integer length;
    Button btn;
    CheckBox check;
    RadioGroup group;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        text = findViewById(R.id.text);
        btn = findViewById(R.id.btn);
        check = findViewById(R.id.check);
        group = findViewById(R.id.group);
        text_size = findViewById(R.id.text_size);


        message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                length = editable.length();
                text.setText(length + " / 80");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Button Click!", Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    check.setText("is Checked");
                }
                else{
                    check.setText("is unChecked");
                }
            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if(id == R.id.radio1){
                    Toast.makeText(getApplicationContext(), "남자 선택", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.radio2){
                    Toast.makeText(getApplicationContext(), "여자 선택", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Resources res = getResources();
        bitmap = (BitmapDrawable)res.getDrawable(R.drawable.iu);
        int bitWidth = bitmap.getIntrinsicWidth();
        int bitHeight = bitmap.getIntrinsicHeight();
        text_size.setText(bitWidth + " * " + bitHeight);
    }
}
