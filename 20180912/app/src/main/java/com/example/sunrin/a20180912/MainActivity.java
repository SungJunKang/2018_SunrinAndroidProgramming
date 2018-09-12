package com.example.sunrin.a20180912;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockDialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        items = new ArrayList<>();
        items.add(new Movie("서치", "드라마", R.drawable.movie1));
        items.add(new Movie("너의 결혼식", "로맨스", R.drawable.movie2));
        items.add(new Movie("신과 함께", "판타지", R.drawable.movie3));

        MovieAdapter adapter = new MovieAdapter(this, R.layout.item, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = items.get(i);

                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                intent.putExtra("resId", movie.resId);
                startActivity(intent);
            }
        });
    }
}
