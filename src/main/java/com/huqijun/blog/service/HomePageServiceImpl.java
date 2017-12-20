package com.huqijun.blog.service;

import com.huqijun.blog.article.ArticleDescription;
import com.huqijun.blog.article.ArticleDespComparator;
import com.huqijun.blog.article.ArticleDetail;
import com.huqijun.blog.util.FileUtil;
import com.huqijun.blog.util.RegUtil;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huqijun on 11/23/2017.
 */
@Component
public class HomePageServiceImpl implements  HomePageService {

    //list of articles
    private List<ArticleDescription>  articleList = new ArrayList<>();

    //the html content of articles,  article name as key
    private Map<String, String>  articleContent = new HashMap<>();


    private static final String blogPath = HomePageServiceImpl.class.getClassLoader().getResource("blog").getPath();

    //reg match key word
    private static final String titileProperty = "title";
    private static final String dateProperty ="date";
    private static final String tagProperty ="tags";


    public HomePageServiceImpl() {
        generateArticles();
    }

    /**
     * handle the origin content of  article read from markdown file
     * the article has the fowllowing format
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
                 articleContent.put(article.getValue().getArticleName(), article.getValue().getHtmlContent());
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
    public String getDetail(String articleName) {
        return articleContent.get(articleName);
    }

    @Override
    public List<ArticleDescription> getArticleList() {
        return articleList;
    }

}
