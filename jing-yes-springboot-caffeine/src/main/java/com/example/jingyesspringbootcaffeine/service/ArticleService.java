package com.example.jingyesspringbootcaffeine.service;

import com.example.jingyesspringbootcaffeine.model.Article;
import org.apache.tomcat.util.http.parser.Upgrade;

public interface ArticleService {
    Article add(Article article);
    void update(Article article);
    Article getById(Integer id);
    void delete(Integer id);
}
