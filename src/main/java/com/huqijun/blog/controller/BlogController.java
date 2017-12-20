package com.huqijun.blog.controller;

import com.huqijun.blog.article.ArticleDescription;
import com.huqijun.blog.service.HomePageServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
        String htmlContent = homePageService.getDetail( homePageService.getArticleName(tags) );
        model.addAttribute("blogDetail", htmlContent);
        return "detail";
    }

}
