package com.example.test10;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonHolder {
    ImageView photoImageView, callImageView;
    TextView itemNameView, itemDateView;

    public PersonHolder(View root){
        photoImageView = root.findViewById(R.id.item_photo);
        itemNameView = root.findViewById(R.id.item_name);
        itemDateView = root.findViewById(R.id.item_date);
        callImageView = root.findViewById(R.id.call);
    }
}
