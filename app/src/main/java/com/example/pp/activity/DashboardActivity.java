package com.example.pp.activity;

import android.os.Bundle;
import android.view.Menu;

import com.example.pp.R;
import com.example.pp.activity.dialog.ShowNewsDialog;
import com.example.pp.activity.communication.OnSelectItemRecyclerView;
import com.example.pp.activity.recycler.RecyclerUtil;
import com.example.pp.activity.recycler.news.NewsAdapter;
import com.example.pp.model.news.News;
import com.example.pp.service.NewsService;
import com.example.pp.service.imp.NewsServiceImp;
import com.example.pp.util.ToastUtil;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardActivity extends AppCompatActivity implements OnSelectItemRecyclerView<News> {
    private NewsService newsService;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Objects.requireNonNull(getSupportActionBar()).hide();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        ShowNewsDialog dialog = new ShowNewsDialog(obj);
        dialog.show(getSupportFragmentManager(), "news");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //todo управление поведением меню
        // https://habr.com/ru/post/256643/
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
