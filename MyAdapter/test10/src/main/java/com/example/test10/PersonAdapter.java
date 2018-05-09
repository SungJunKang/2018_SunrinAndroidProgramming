package com.example.test10;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter {

    Context context;
    int layoutId;
    ArrayList<Person> datas;

    public PersonAdapter(@NonNull Context context, int resource, ArrayList<Person> datas) {
        super(context, resource, datas);
        this.context = context;
        layoutId = resource;
        this.datas = datas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId, null);
            PersonHolder holder = new PersonHolder(convertView);
            convertView.setTag(holder);
        }

        PersonHolder holder = (PersonHolder)convertView.getTag();
        ImageView photoImageView = holder.photoImageView;
        TextView itemNameView = holder.itemNameView;
        TextView itemDateView = holder.itemDateView;
        ImageView callImageView = holder.callImageView;

        final Person person = datas.get(position);

        itemNameView.setText(person.name);
        itemDateView.setText(person.date);

        if(person.photo.equals("yes")){
            photoImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),
                    R.drawable.hong, null));
        }

        if(person.photo.equals("no")){
            photoImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(),
                    R.drawable.ic_person, null));
        }

        callImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + person.phone));
                context.startActivity(intent);

            }
        });

        return convertView;
    }
}
