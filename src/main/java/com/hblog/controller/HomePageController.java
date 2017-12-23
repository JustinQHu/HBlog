package com.hblog.controller;

import com.hblog.article.ArticleDescription;
import com.hblog.service.HomePageServiceImpl;
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
@RequestMapping({"/", "/home"})
public class HomePageController {

    @Autowired
    private HomePageServiceImpl homePageService;


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model)
    {
        List<ArticleDescription> articleDescriptionList = homePageService.getArticleList();
        model.addAttribute("articleDescriptionList" ,articleDescriptionList);
        return "home";
    }

}
