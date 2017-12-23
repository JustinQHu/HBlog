package com.hblog.service;

import com.hblog.article.ArticleDetail;
import com.hblog.article.ArticleDescription;
import com.hblog.article.ArticleDespComparator;
import com.hblog.util.FileUtil;
import com.hblog.util.RegUtil;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by huqijun on 11/23/2017.
 */
@Component
public class HomePageServiceImpl implements  HomePageService {

    //list of articles
    private List<ArticleDescription>  articleList = new ArrayList<>();

    //the detail of articles,  article name as key
    private Map<String, ArticleDetail>  articleContent = new HashMap<>();


    /**
     * the path depends on how you deploy you webapp , here in my case blog is in the same level as c
     */
    private static final String blogPath = HomePageServiceImpl.class.getClassLoader().getResource("../blog").getPath();


    //reg match key word
    private static final String titileProperty = "title";
    private static final String dateProperty ="date";
    private static final String tagProperty ="tags";


    public HomePageServiceImpl() {

        generateArticles();
    }

    /**
     * handle the origin content of  article read from markdown file
     * the article has the following format for example:
     *        title: main函数的第三个参数envp
     *        date: 2016-06-16 23:32:13
     *        categories: C++
     *        tags: C++
     *        ---
     *        articleContent here
     * @param origin
     */
    public Pair<ArticleDescription, ArticleDetail> articleProcess(String origin)
    {
        //get article content
        String markdownContent = origin.substring(  origin.indexOf("---")  + 3).trim();
        String title = RegUtil.foundArticleProperties(titileProperty, origin).trim();
        String tag = RegUtil.foundArticleProperties(tagProperty, origin).trim();
        String dateTimeTemp = RegUtil.foundArticleProperties(dateProperty, origin).trim();
        dateTimeTemp = dateTimeTemp.replace(" ", "T");

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeTemp);

        ArticleDescription articleDescription = new ArticleDescription(title, tag, dateTime);
        ArticleDetail articleDetail = new ArticleDetail(title , markdownContent);

        return new Pair<>(articleDescription,articleDetail);
    }

    /**
     * generate article contents : articleList &  articleContent from markdown files
     */
    private void generateArticles()
    {
        List<String> ls;
        try {
             ls = FileUtil.readAll(blogPath);
             for(String origContent : ls)
             {
                 Pair<ArticleDescription, ArticleDetail>  article = articleProcess(origContent);
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

}
