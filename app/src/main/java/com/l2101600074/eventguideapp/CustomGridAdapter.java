package com.l2101600074.eventguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CustomGridAdapter extends ArrayAdapter<Event> {

    public CustomGridAdapter(@NonNull Context context, ArrayList<Event> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item_one, parent, false);
        }

        Event event = getItem(position);
        TextView title = listitemView.findViewById(R.id.txt_title);
        TextView descrption = listitemView.findViewById(R.id.txt_desciption);
        ImageView Image = listitemView.findViewById(R.id.IM_image);

        title.setText(event.getTitle());
        descrption.setText(event.getDescription());
        //Image.setImageResource(event.getImage());
        return listitemView;
    }
}

