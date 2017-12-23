package com.hblog.article;

import java.time.LocalDateTime;

/**
 * Created by huqijun on 11/22/2017.
 * 文章的概要信息
 */
public class ArticleDescription {

    //article name
    private String articleName;

    //tag of article
    private String tag;

    //article digest
    private String digest;

    private LocalDateTime publishDate;

    //read accout of article
    private int readCount;

    //account of comments of this article
    private int comments;


    public ArticleDescription(String articleName, String tag, LocalDateTime publishDate) {
        this.articleName = articleName;
        this.tag = tag;
        this.publishDate = publishDate;
        this.digest = "";
        this.readCount = 0;
        this.comments = 0;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }



}
