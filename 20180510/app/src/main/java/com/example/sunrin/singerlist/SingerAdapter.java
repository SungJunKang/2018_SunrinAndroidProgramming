package com.example.sunrin.singerlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SingerAdapter extends ArrayAdapter<SingerItem> {
    Context context;
    int resId;
    ArrayList<SingerItem> datas;

    public SingerAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SingerItem> objects) {
        super(context, resource, objects);
        this.context = context;
        resId = resource;
        datas = objects;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflation
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);
            SingerHolder holder = new SingerHolder(convertView);
            convertView.setTag(holder);
        }

        // findViewById로 객체 찾기
        SingerHolder holder = (SingerHolder)convertView.getTag();
        ImageView imageView = holder.imageView;
        TextView textView = holder.textView;
        TextView textView2 = holder.textView2;
        TextView textView3 = holder.textView3;

        // view에 data 설정
        SingerItem singer = datas.get(position);
        imageView.setImageResource(singer.imageId);
        textView.setText(singer.name);
        textView2.setText(singer.tel);
        textView3.setText(String.valueOf(singer.memberCount));

        return convertView;
    }
}
