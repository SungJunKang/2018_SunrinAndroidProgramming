package com.example.sunrin.a20180912;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieHolder {

    ImageView imageView;
    TextView titleView, genreView;

    public MovieHolder(View convertView){
        imageView = convertView.findViewById(R.id.imageView);
        titleView = convertView.findViewById(R.id.titleView);
        genreView = convertView.findViewById(R.id.genreView);
    }
}
