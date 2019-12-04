package com.example.pp.model.news;

import com.example.pp.model.AbstractBaseEntity;

import java.util.Date;
import java.util.Objects;

public class News extends AbstractBaseEntity {
    private String title;
    private String text;
    private Date date;

    public News() {
    }

    public News(String title, String text, Date date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public News(Integer id, String title, String text, Date date) {
        super(id);
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(title, news.title) &&
                Objects.equals(text, news.text) &&
                Objects.equals(date, news.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, date);
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
