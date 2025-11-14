package com.example.voyaji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DestinationAdapter extends BaseAdapter {

    Context context;
    List<Destination> list;

    public DestinationAdapter(Context context, List<Destination> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.row_destination, parent, false);

        ImageView img = convertView.findViewById(R.id.imgCity);
        TextView txtCity = convertView.findViewById(R.id.txtCity);
        TextView txtPrice = convertView.findViewById(R.id.txtPrice);

        Destination d = list.get(position);

        img.setImageResource(d.image);
        txtCity.setText(d.city);
        txtPrice.setText(d.price + " MAD");

        return convertView;
    }
}

