package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:   文章的实体类
 * @Author zhy
 * @Date 2018-07-08 20:57
 */
public class Article implements Serializable {
    private String articleId;
    private String articleName;
    private String articleContent;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;
    private String articleStatus;
    private Master master;

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", publishDate=" + publishDate +
                ", articleStatus='" + articleStatus + '\'' +
                ", master=" + master +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Article(String articleId, String articleName, String articleContent, Date publishDate, String articleStatus, Master master) {

        this.articleId = articleId;
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.publishDate = publishDate;
        this.articleStatus = articleStatus;
        this.master = master;
    }

    public Article() {

    }
}
