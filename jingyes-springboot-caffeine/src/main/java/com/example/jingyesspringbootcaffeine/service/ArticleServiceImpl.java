package com.example.jingyesspringbootcaffeine.service;

import com.example.jingyesspringbootcaffeine.model.Article;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Cache
 */
@Service
@CacheConfig(cacheNames = "ArticleServiceImpl")
public class ArticleServiceImpl implements ArticleService {
    private static Map<Integer, Article> mockDB = new HashMap<>();

    @Override
    @CachePut(key = "#article.id")
    public Article add(Article article) {
        mockDB.put(article.getId(), article);
        return article;
    }

    @Override
    @CachePut(key = "#article.id")
    public Article update(Article article) {
        Article model = mockDB.get(article.getId());
        if (model != null) {
            model.setTitle(article.getTitle());
            mockDB.put(model.getId(), model);
        }
        return model;
    }

    @Override
    @Cacheable(key = "#id")
    public Article getById(Integer id) {
        System.out.println("getById from DB,id=" + id);
        return mockDB.get(id);
    }

    @Override
    @CacheEvict(key = "#id")
    public void delete(Integer id) {
        mockDB.remove(id);
    }
}
