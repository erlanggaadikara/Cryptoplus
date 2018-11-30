package com.helloworld.erlangga.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<Article> articleList;

    public NewsAdapter(Context context, List<Article> articleList){
        this.context = context;
        this.articleList = articleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewnews,parent,false);
        v.setMinimumWidth(parent.getMeasuredWidth());
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, final int position) {
        final Article articlemodel = articleList.get(position);
        if(!TextUtils.isEmpty(articlemodel.getTitle())){
            holder.titleText.setText(articlemodel.getTitle());
        }

        if(!TextUtils.isEmpty(articlemodel.getUrlToImage())){
            Picasso.with(context)
            .load(articlemodel.getUrlToImage())
            .fit()
            .into(holder.image);
        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, webview.class);
                i.putExtra("url",articleList.get(position).getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titleText;
        ImageView image;


        public ViewHolder(View itemView){
            super(itemView);
            titleText = itemView.findViewById(R.id.nme1);
            image = itemView.findViewById(R.id.img1);
        }

    }
}
