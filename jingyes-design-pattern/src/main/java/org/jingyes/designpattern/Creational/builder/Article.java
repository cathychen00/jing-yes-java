package org.jingyes.designpattern.Creational.builder;

import java.util.Date;
import java.util.List;

/**
 * 建造者模式Builder
 *
 * @author jingyes
 * @date 2024/1/15
 */
public class Article {
    private Integer id;
    private String title;
    private Date publishTime;
    private String smallTitle;
    private String summary;
    private String content;


    public Article(ArticleBuilder builder){
        this.id=builder.id;
        this.title= builder.title;
        this.publishTime=builder.publishTime;
        this.smallTitle= builder.smallTitle;;
        this.summary= builder.summary;
        this.content=builder.content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishTime=" + publishTime +
                ", smallTitle='" + smallTitle + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public static class ArticleBuilder{
        private Integer id;
        private String title;
        private Date publishTime;
        private String smallTitle;
        private String summary;
        private String content;

        public ArticleBuilder(Integer id, String title) {
            this.id = id;
            this.title = title;
        }
        public ArticleBuilder withPublishTime(Date publishTime){
            this.publishTime=publishTime;
            return this;
        }
        public ArticleBuilder withSmallTitle(String smallTitle){
            this.smallTitle=smallTitle;
            return this;
        }
        public ArticleBuilder withSummary(String summary){
            this.summary=summary;
            return this;
        }
        public ArticleBuilder withContent(String content){
            this.content=content;
            return this;
        }
        public Article build(){
            return new Article(this);
        }
    }
}

