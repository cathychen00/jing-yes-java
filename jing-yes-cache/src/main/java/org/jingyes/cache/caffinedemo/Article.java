package org.jingyes.cache.caffinedemo;

public class Article {
    private Integer id;
    private String title;

    public Article(Integer id) {
        this.id = id;
        this.title = "title " + id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
