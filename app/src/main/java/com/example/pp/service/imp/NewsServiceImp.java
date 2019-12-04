package com.example.pp.service.imp;

import android.content.Context;

import com.example.pp.data.NewsRepositoryLite;
import com.example.pp.data.imp.news.NewsRepositoryLiteImp;
import com.example.pp.model.news.News;
import com.example.pp.service.NewsService;

import java.util.List;

public class NewsServiceImp implements NewsService {
    private NewsRepositoryLite repository;

    public NewsServiceImp(Context context) {
        this.repository = new NewsRepositoryLiteImp(context);
    }

    @Override
    public void save(News news) {
        repository.save(news);
    }

    @Override
    public void delete(News news) {
        repository.delete(news.getId());
    }

    @Override
    public News get(int id) {
        return repository.get(id);
    }

    @Override
    public void update(News news) {
        repository.update(news);
    }

    @Override
    public List<News> getAll() {
        return repository.getAll();
    }

    @Override
    public void saveAll(List<News> list) {
        for(News news : list){
            repository.save(news);
        }
    }
}
