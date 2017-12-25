package com.hblog.service;

import com.hblog.article.ArticleDescription;
import com.hblog.article.ArticleDetail;
import com.hblog.util.RegUtil;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by huqijun on 12/25/2017.
 */
@Component
public class ArticleServiceImpl implements ArticleService {

    //reg match key word
    private static final String titileProperty = "title";
    private static final String dateProperty ="date";
    private static final String tagProperty ="tags";


    /**
     * handle the origin content of  article read from markdown file
     * the article has the following format for example:
     *        title: main函数的第三个参数envp
     *        date: 2016-06-16 23:32:13
     *        categories: C++
     *        tags: C++
     *        ---
     *        articleContent here
     *        ********************
     * @param origin
     */
    @Override
    public Pair<ArticleDescription, ArticleDetail> articleProcess(String origin) {
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



}
