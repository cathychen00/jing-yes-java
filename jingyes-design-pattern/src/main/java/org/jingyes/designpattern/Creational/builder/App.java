package org.jingyes.designpattern.Creational.builder;

import java.util.Date;

/**
 * @author jingyes
 * @date 2024/1/15
 */
public class App {
    public static void main(String[] args) {
        Article article = new Article.ArticleBuilder(1, "测试")
                .withPublishTime(new Date())
                .withSummary("精选文章测试摘要")
                .withContent("文章正文文章正文文章正文文章正文")
                .build();
        System.out.println(article.toString());
    }
}
