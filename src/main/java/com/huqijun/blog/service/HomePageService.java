package com.huqijun.blog.service;

import com.huqijun.blog.article.ArticleDescription;

import java.util.List;

/**
 * Created by huqijun on 11/23/2017.
 */
public interface HomePageService {

    //get list of articles
    List<ArticleDescription>   getArticleList();

    //get article name by its tag
    String getArticleName(String tag);

    //get detail content of an article in html format by name
    String getDetail(String articleName);
}
