package com.example.sunrin.mypreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id, et_pw;
    Button btn;
    CheckBox check;
    String loginId;
    boolean checkValue;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et1);
        et_pw = findViewById(R.id.et2);
        btn = findViewById(R.id.btn);
        check = findViewById(R.id.checkBox);

        // SharedPreferences 객체 획득
        pref = getSharedPreferences("Myprefs", MODE_PRIVATE);

        // 이미 저장되어 있는 loginId, checkValue 불러오기
        loginId = pref.getString("loginId", "");
        checkValue = pref.getBoolean("check", false);

        // 화면에 보여주기
        et_id.setText(loginId);
        check.setChecked(checkValue);

        // 버튼 클릭하면 새로운 값 저장
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();

                // 아이디 저장이 체크 되어 있다면 새로운 값 저장
                if(check.isChecked()){
                    loginId = et_id.getText().toString();
                    editor.putString("loginId", loginId);
                    editor.putBoolean("check", true);
                    Toast.makeText(getApplicationContext(), "로그인 아이디가 저장되었습니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    // 아이디 저장이 체크 해제되어 있다면 기존에 저장된 값 지우기
                    editor.putString("loginId", "");
                    editor.putBoolean("check", false);
                }

                // editor 완료
                editor.commit();
            }
        });
    }
}
