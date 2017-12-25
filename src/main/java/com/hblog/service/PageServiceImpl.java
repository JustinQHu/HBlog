package com.hblog.service;

import com.hblog.article.ArticleDetail;
import com.hblog.article.ArticleDescription;
import com.hblog.article.ArticleDespComparator;
import com.hblog.util.FileUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * Created by huqijun on 11/23/2017.
 */
@Component
public class PageServiceImpl implements PageService , InitializingBean {

    //list of articles
    private List<ArticleDescription>  articleList;

    //the detail of articles,  article name as key
    private Map<String, ArticleDetail>  articleContent;

    @Autowired
    private ArticleService articleService;


    /**
     * the path depends on how you deploy you webapp , here in my case blog is in the same level as classes.
     */
    private static final String blogPath = PageServiceImpl.class.getClassLoader().getResource("../blog").getPath();


    public PageServiceImpl() {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.refreshCache();
    }

    /**
     * generate article contents : articleList &  articleContent from markdown files
     * @param articleList requires not null
     * @param articleContent requires not null
     */
    private void generateArticles(List<ArticleDescription> articleList,  Map<String, ArticleDetail>  articleContent)
    {
        try {
             List<String> ls = FileUtil.readAll(blogPath);
             for(String origContent : ls)
             {
                 Pair<ArticleDescription, ArticleDetail>  article = articleService.articleProcess(origContent);
                 articleList.add(article.getKey());
                 articleContent.put(article.getValue().getArticleName(), article.getValue());
             }

             //sort by publishDate
            Collections.sort(articleList,   new ArticleDespComparator());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public String getArticleName(String tag) {
        for(ArticleDescription  ar : articleList)
        {
            if( ar.getTag().equals(tag) )
                return  ar.getArticleName();
        }

        return null;
    }

    @Override
    public ArticleDetail getDetail(String articleName) {
        return articleContent.get(articleName);
    }

    @Override
    public String getHtml(String articleName) {
        return articleContent.get(articleName).getHtmlContent();
    }

    @Override
    public String getMarkdown(String articleName) {
        return articleContent.get(articleName).getMarkdownContent();
    }

    @Override
    public List<ArticleDescription> getArticleList() {
        return articleList;
    }


    @Override
    public void refreshCache() {

        List<ArticleDescription>  articleList = new ArrayList<>();
        Map<String, ArticleDetail>  articleContent = new HashMap<>();
        generateArticles(articleList, articleContent);

        this.articleList = articleList;
        this.articleContent = articleContent;
    }
}
