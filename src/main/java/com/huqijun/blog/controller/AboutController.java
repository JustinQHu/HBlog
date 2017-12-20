package com.huqijun.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huqijun on 11/23/2017.
 * About Page Request
 */
@Controller
public class AboutController {

    @RequestMapping(value = "/about",  method = RequestMethod.GET)
    public String getAbout()
    {
        return "about";
    }

}
