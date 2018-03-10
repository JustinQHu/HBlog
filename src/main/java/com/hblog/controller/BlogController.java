package com.hblog.controller;

import com.hblog.article.ArticleDescription;
import com.hblog.article.ArticleDetail;
import com.hblog.service.PageService;
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

    /**
     * object managed by Spring IOC,  single instance.
     */
    @Autowired
    private PageService pageService;

    @RequestMapping(method = RequestMethod.GET)
    public String BlogHome(Model model)
    {
        List<ArticleDescription> articleDescriptionList = pageService.getArticleList();
        model.addAttribute("articleDescriptionList" ,articleDescriptionList);
        return "bloghome";
    }



    @RequestMapping(value = "/{publishDate}/{tags}",method = RequestMethod.GET)
    public String Detail(Model model,
                         @PathVariable("publishDate") String publishDate,
                         @PathVariable("tags") String tags
                         )
    {
        String name = pageService.getArticleName(tags);
        ArticleDetail article = pageService.getDetail( name );
        model.addAttribute("blogDetail", article);
        return "detail";
    }

}
