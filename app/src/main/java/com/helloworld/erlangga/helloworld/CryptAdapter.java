package com.helloworld.erlangga.helloworld;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CryptAdapter extends BaseAdapter {
    Context c;
    ArrayList<titleicon> ti;

    public CryptAdapter(Context c, ArrayList<titleicon> ti){
        this.c = c;
        this.ti = ti;
    }

    @Override
    public int getCount() {
        return ti.size();
    }

    @Override
    public Object getItem(int position) {
        return ti.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(c).inflate(R.layout.cardviewcrypt,parent,false);
        }

        final titleicon s = (titleicon) this.getItem(position);

        ImageView imgview = convertView.findViewById(R.id.img);
        TextView txtview = convertView.findViewById(R.id.nme);

        txtview.setText(s.getName());
        imgview.setImageResource(s.getImage());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;

                v.getContext().startActivity(intent);
            }
        });
        return convertView;
    }

}
