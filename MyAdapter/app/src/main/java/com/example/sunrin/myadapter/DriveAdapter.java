package com.example.sunrin.myadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DriveAdapter extends ArrayAdapter {

    Context context;
    int layoutId;
    ArrayList<Drive> datas;

    public DriveAdapter(@NonNull Context context, int resource, ArrayList<Drive> datas) {
        super(context, resource, datas);
        this.context = context;
        layoutId = resource;
        this.datas = datas;
    }

    // item 개수만큼 자동 호출.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // custom_item 객체화 시켜줌(inflation)
        // 성능 이슈와 관련하여 1번만 실행
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId, null);
            DriveHolder holder = new DriveHolder(convertView);
            convertView.setTag(holder);
        }

        // view 객체 findViewById 로 찾아오기
        DriveHolder holder = (DriveHolder)convertView.getTag();
        ImageView typeImageView = holder.typeImageView;
        TextView itemTitleView = holder.titleView;
        TextView itemDateView = holder.dateView;
        ImageView menuImageView = holder.menuImageView;

        Drive drive = datas.get(position);

        itemTitleView.setText(drive.title);
        itemDateView.setText(drive.date);

        if(drive.type.equals("doc")){
            typeImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(context.getResources(),
                            R.drawable.ic_type_doc, null));
        }

        if(drive.type.equals("file")){
            typeImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(context.getResources(),
                            R.drawable.ic_type_file, null));
        }

        if(drive.type.equals("img")){
            typeImageView.setImageDrawable(
                    ResourcesCompat.getDrawable(context.getResources(),
                            R.drawable.ic_type_image, null));
        }

        menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "menu click!", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
