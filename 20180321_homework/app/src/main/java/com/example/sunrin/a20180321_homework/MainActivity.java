package com.example.sunrin.a20180321_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_id, edit_name, edit_address;
    RadioGroup inputage;
    Button btn_save, btn_close;
    String id, name, address, age;
    CheckBox checkBox;
    boolean isChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_id = findViewById(R.id.edit_id);
        edit_name = findViewById(R.id.edit_name);
        edit_address = findViewById(R.id.edit_address);
        inputage = findViewById(R.id.inputage);
        btn_save = findViewById(R.id.btn_save);
        btn_close = findViewById(R.id.btn_close);
        checkBox = findViewById(R.id.checkbox);

        inputage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch(id){
                    case R.id.age_10:
                        age = "10대";
                        break;
                    case R.id.age_20:
                        age = "20대";
                        break;
                    case R.id.age_30:
                        age ="30대 이상";
                        break;
                }
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    isChecked = true;
                }
                else{
                    isChecked = false;
                }
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isChecked){
                    id = edit_id.getText().toString();
                    name = edit_name.getText().toString();
                    address = edit_address.getText().toString();

                    Toast.makeText(getApplicationContext(), "아이디 : " + id + " 이름 : " + name + " 나이 : " + age + "로 저장되었습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "약관을 체크해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
