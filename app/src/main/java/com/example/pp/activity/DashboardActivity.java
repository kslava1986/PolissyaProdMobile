package com.example.pp.activity;

import android.os.Bundle;

import com.example.pp.R;
import com.example.pp.activity.fragment.communication.OnSelectItemRecyclerView;
import com.example.pp.activity.recycler.RecyclerUtil;
import com.example.pp.activity.recycler.news.NewsAdapter;
import com.example.pp.model.news.News;
import com.example.pp.service.NewsService;
import com.example.pp.service.imp.NewsServiceImp;
import com.example.pp.util.ToastUtil;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardActivity extends AppCompatActivity implements OnSelectItemRecyclerView<News> {
    private NewsService newsService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Objects.requireNonNull(getSupportActionBar()).hide();

        newsService = new NewsServiceImp(this);

        RecyclerView recyclerView = RecyclerUtil.createRecycler(this);
        NewsAdapter adapter = new NewsAdapter(this, this, newsService.getAll());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void selectItem(News obj) {
        //todo тестовый тостер
        ToastUtil.showLongToast(this, "Long Toast \n" + "Select item: \n"
                + "id: " + obj.getId()
                + "\ntitle: " + obj.getTitle());



    }
}
