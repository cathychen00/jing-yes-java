package com.example.jingyesspringbootcaffeine.service;

import com.example.jingyesspringbootcaffeine.model.Article;

public interface ArticleService {
    Article add(Article article);
    Article update(Article article);
    Article getById(Integer id);
    void delete(Integer id);
}
