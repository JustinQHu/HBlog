package com.hblog.controller;

import com.hblog.article.ArticleDescription;
import com.hblog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by huqijun on 11/22/2017.
 * homepage of blog
 */

@Controller
@RequestMapping({"/"})
public class HomePageController {

    /**
     * object managed by Spring IOC,  single instance.
     */
    @Autowired
    private PageService pageService;


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model)
    {
        List<ArticleDescription> articleDescriptionList = pageService.getArticleList();
        model.addAttribute("articleDescriptionList" ,articleDescriptionList);
        //use bloghome page as home page provisionally
        return "bloghome";
    }

}
