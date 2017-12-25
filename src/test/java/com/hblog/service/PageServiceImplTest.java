package com.hblog.service;

import com.hblog.article.ArticleDescription;
import com.hblog.conf.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huqijun on 12/25/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class PageServiceImplTest {

    @Autowired
    PageService pageService;

    @Test
    public void getArticleName() throws Exception {
        System.out.println( pageService.getArticleName("VPN" ) );
        System.out.println( pageService.getArticleName("YoutubeEnglishLearning" ) );
    }

    @Test
    public void getDetail() throws Exception {
        System.out.println( pageService.getDetail( pageService.getArticleName("VPN" ) ));
    }

    @Test
    public void getArticleList() throws Exception {
        List<ArticleDescription> articles = pageService.getArticleList();

        for(ArticleDescription ar :  articles)
        {
            System.out.println(ar.getArticleName() + " " +  ar.getPublishDate() + " " + ar.getTag());
        }

    }

}