package com.example.sunrin.a20180912;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {

    Context context;
    ArrayList<Movie> items;
    int layoutId;

    public MovieAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        this.context = context;
        this.items = objects;
        this.layoutId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, null);

            MovieHolder holder = new MovieHolder(convertView);
            convertView.setTag(holder);
        }

        MovieHolder holder = (MovieHolder) convertView.getTag();
        Movie movie = items.get(position);

        holder.titleView.setText(movie.title);
        holder.genreView.setText(movie.genre);
        holder.imageView.setImageResource(movie.resId);

        return convertView;
    }
}
