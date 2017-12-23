package com.hblog.controller;

import com.hblog.article.ArticleDetail;
import com.hblog.service.HomePageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huqijun on 11/22/2017.
 * handle blog detail request
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private HomePageServiceImpl homePageService;


    @RequestMapping(value = "/{publishDate}/{tags}",method = RequestMethod.GET)
    public String Detail(Model model,
                         @PathVariable("publishDate") String publishDate,
                         @PathVariable("tags") String tags
                         )
    {
        String name = homePageService.getArticleName(tags);
        ArticleDetail article = homePageService.getDetail( name );
        model.addAttribute("blogDetail", article);
        return "detail";
    }

}
