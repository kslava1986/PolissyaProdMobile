package com.example.pp.activity.recycler.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pp.R;
import com.example.pp.activity.communication.OnSelectItemRecyclerView;
import com.example.pp.model.news.News;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{

    private Context context;
    private List<News> list;
    private OnSelectItemRecyclerView<News> onSelectItemRecyclerView;

    public NewsAdapter(Context context, OnSelectItemRecyclerView<News> onSelectItemRecyclerView, List<News> list) {
        this.context = context;
        this.list = list;
        this.onSelectItemRecyclerView = onSelectItemRecyclerView;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_item, viewGroup,  false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, final int position) {
        final News news = list.get(position);

        newsViewHolder.setTitle(news.getTitle());
        newsViewHolder.setText(news.getText());
        newsViewHolder.setDate(news.getDate());

        //todo реализовать анимацию при нажатии на пункт меню
        newsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectItemRecyclerView.selectItem(news);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
