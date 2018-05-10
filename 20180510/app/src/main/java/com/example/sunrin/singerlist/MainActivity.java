package com.example.sunrin.singerlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<SingerItem> datas;
    SingerAdapter singerAdapter;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView singerList = findViewById(R.id.singerList);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);

        // data 준비
        datas = new ArrayList<SingerItem>();
        datas.add(new SingerItem("소녀시대", "010-2233-4456", 9, R.drawable.singer));
        datas.add(new SingerItem("여자친구", "010-3344-5566", 6, R.drawable.singer2));
        datas.add(new SingerItem("러블리즈", "010-9988-1122", 10, R.drawable.singer3));
        datas.add(new SingerItem("우주소녀", "010-4455-1199", 12, R.drawable.singer4));
        datas.add(new SingerItem("구구단", "010-3377-8765", 12, R.drawable.singer5));

        // apdater 생성
        singerAdapter = new SingerAdapter(this,
                R.layout.singer_item2, datas);

        // listView에 adapter 설정
        singerList.setAdapter(singerAdapter);


        //item 클릭 이벤트
        singerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (datas.get(position)).name;
                Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();
                datas.remove(position);
                singerAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View view) {
        SingerItem singer = new SingerItem(editText.getText().toString());
        datas.add(singer);
        singerAdapter.notifyDataSetChanged();
    }
}
