package com.example.sunrin.myadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DriveHolder {
    ImageView typeImageView, menuImageView;
    TextView titleView, dateView;

    public DriveHolder(View root){
        typeImageView = root.findViewById(R.id.type_img);
        menuImageView = root.findViewById(R.id.menu_img);
        titleView = root.findViewById(R.id.item_title);
        dateView = root.findViewById(R.id.item_date);
    }
}
