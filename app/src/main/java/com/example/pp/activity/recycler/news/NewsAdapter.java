package com.example.pp.activity.recycler.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pp.R;
import com.example.pp.model.news.News;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{

    private Context context;
    private List<News> list;

    public NewsAdapter(Context context, List<News> list) {
        this.context = context;
        this.list = list;
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
        News news = list.get(position);

        newsViewHolder.setTitle(news.getTitle());
        newsViewHolder.setText(news.getText());
        newsViewHolder.setDate(news.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
