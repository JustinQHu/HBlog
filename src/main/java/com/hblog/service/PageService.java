package com.hblog.service;

import com.hblog.article.ArticleDescription;
import com.hblog.article.ArticleDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by huqijun on 11/23/2017.
 */
public interface PageService {


    /**
     * get list of articles
     * @return
     */
    List<ArticleDescription>   getArticleList();


    /**
     * get article name by its tag
     * @param tag
     * @return
     */
    String getArticleName(String tag);


    /**
     * get detail an article by name
     * @param articleName
     * @return
     */
    ArticleDetail getDetail(String articleName);


    /**
     * get html content of an article by name
     * @param articleName
     * @return
     */
    String getHtml(String articleName);

    /**
     * get markdown content of an article by name
     * @param articleName
     * @return
     */
    String getMarkdown(String articleName);

    /**
     * to refresh the Cache hold in service.
     */
    void refreshCache();
}
