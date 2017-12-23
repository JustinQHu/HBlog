package com.hblog.service;

import com.hblog.article.ArticleDescription;
import com.hblog.article.ArticleDetail;

import java.util.List;

/**
 * Created by huqijun on 11/23/2017.
 */
public interface HomePageService {

    //get list of articles
    List<ArticleDescription>   getArticleList();

    //get article name by its tag
    String getArticleName(String tag);

    //get detail an article by name
    ArticleDetail getDetail(String articleName);

    //get html content of an article by name
    String getHtml(String articleName);

    //get markdown content of an article by name
    String getMarkdown(String articleName);
}
