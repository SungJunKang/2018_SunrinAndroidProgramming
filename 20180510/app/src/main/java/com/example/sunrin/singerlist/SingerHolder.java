package com.example.sunrin.singerlist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SingerHolder {
    ImageView imageView;
    TextView textView, textView2, textView3;

    public SingerHolder(View root){
        imageView = root.findViewById(R.id.imageView);
        textView = root.findViewById(R.id.textView);
        textView2 = root.findViewById(R.id.textView2);
        textView3 = root.findViewById(R.id.textView3);
    }
}
