package com.example.pp.data.default_data;

import com.example.pp.model.news.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDefault {

    private NewsDefault() {
    }

    public static final List<News> NEWS = new ArrayList<>();

    static {
        NEWS.add(new News("News-1", "Some text for news-1", new Date()));
        NEWS.add(new News("News-2", "Some text for news-2", new Date()));
        NEWS.add(new News("News-3",
                "Some text for news-3Some text for news-3Some text for news-3" +
                        "Some text for news-3Some text for news-3",
                new Date()));
        NEWS.add(new News("News-4News-4News-4News-4News-4News-4News-4News-4News-4" +
                "News-4News-4News-4News-4News-4", "Some text for news-4Some text for" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4Some text for news-4" +
                "Some text for news-4Some text for news-4Some text for news-4", new Date()));
        NEWS.add(new News("News-5",
                "Some text for news-5Some text for news-5Some text for news-5" +
                        "Some text for news-5Some text for news-5Some text for news-5" +
                        "Some text for news-5Some text for news-5Some text for news-5" +
                        "Some text for news-5Some text for news-5",
                new Date()));
    }
}
