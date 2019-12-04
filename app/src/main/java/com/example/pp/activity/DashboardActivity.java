package com.example.pp.activity;

import android.os.Bundle;

import com.example.pp.R;
import com.example.pp.activity.recycler.RecyclerUtil;
import com.example.pp.activity.recycler.news.NewsAdapter;
import com.example.pp.service.NewsService;
import com.example.pp.service.imp.NewsServiceImp;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardActivity extends AppCompatActivity {
    private NewsService newsService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Objects.requireNonNull(getSupportActionBar()).hide();

        newsService = new NewsServiceImp(this);

        RecyclerView recyclerView = RecyclerUtil.createRecycler(this);
        NewsAdapter adapter = new NewsAdapter(this, newsService.getAll());
        recyclerView.setAdapter(adapter);
    }
}
