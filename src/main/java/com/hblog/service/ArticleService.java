package com.hblog.service;

import com.hblog.article.ArticleDescription;
import com.hblog.article.ArticleDetail;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

/**
 * Created by huqijun on 12/25/2017.
 */
public interface ArticleService {

    /**
     * handle the origin markdown file
     * @param origin
     * @return
     */
    Pair<ArticleDescription, ArticleDetail> articleProcess(String origin);

}
