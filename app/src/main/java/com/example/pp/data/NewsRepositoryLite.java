package com.example.pp.data;

import com.example.pp.model.news.News;

import java.util.List;

public interface NewsRepositoryLite {
    void save(News news);
    void delete(int id);
    News get(int id);
    void update(News news);
    List<News> getAll();
    //todo добавить метод выбора ограниченого количества(max = 20) последних новостей
}
