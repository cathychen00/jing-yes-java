package com.example.jingyesspringbootcaffeine.controllers;

import com.example.jingyesspringbootcaffeine.model.Article;
import com.example.jingyesspringbootcaffeine.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("get")
    public Article get(Integer id) {
        return this.articleService.getById(id);
    }

    @PostMapping("add")
    public String add(Integer id,String title){
        Article article=new Article();
        article.setId(id);
        article.setTitle(title);
        this.articleService.add(article);
        return "1";
    }

    @PostMapping("update")
    public String update(Integer id,String title){
        Article article=new Article();
        article.setId(id);
        article.setTitle(title);
        this.articleService.update(article);
        return "1";
    }

    @PostMapping("delete")
    public String delete(Integer id){
        this.articleService.delete(id);
        return "1";
    }
}
