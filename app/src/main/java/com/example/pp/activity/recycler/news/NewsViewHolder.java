package com.example.pp.activity.recycler.news;

import android.view.View;
import android.widget.TextView;

import com.example.pp.R;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends  RecyclerView.ViewHolder {
    private TextView title;
    private TextView text;
    private TextView date;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.news_item_title);
        text = itemView.findViewById(R.id.news_item_text);
        date = itemView.findViewById(R.id.news_item_date);
    }

    //todo отформатировать выводы
    public void setTitle(String value){
        title.setText(value);
    }

    public void setText(String value){
        text.setText(value);
    }

    public void setDate(Date value){
        date.setText(String.valueOf(value.getTime()));
    }
}
