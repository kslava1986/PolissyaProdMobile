package com.example.pp.service;

import com.example.pp.model.news.News;

import java.util.List;

public interface NewsService {
    void save(News news);
    void delete(News news);
    News get(int id);
    void update(News news);
    List<News> getAll();
    void saveAll(List<News> list);
}
