package com.hblog.article;

import java.util.Comparator;

/**
 * Created by huqijun on 11/23/2017.
 * ArticleDescription 对象排序Comparator ,  根据publishDate 排序
 */
public class ArticleDespComparator implements Comparator<ArticleDescription> {

    @Override
    public int compare(ArticleDescription o1, ArticleDescription o2) {
        return o2.getPublishDate().compareTo( o1.getPublishDate() );
    }
}
