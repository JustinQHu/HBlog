package com.hblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huqijun on 11/23/2017.
 * About Page Request
 *
 *
 * update in 12/23/2017:
 *  *  rename to SimpleController, which handles all simple page request ,eg about page, wetchatPubAccoutn Page.
 *
 */
@Controller
public class SimpleController {

    /**
     * Display the About Page, that is about.jsp .
     * @return
     */
    @RequestMapping(value = "/about",  method = RequestMethod.GET)
    public String getAbout()
    {
        return "about";
    }


    /**
     * Display the WechatPubAccount Page : pubaccout.jsp
     * @return
     */
    @RequestMapping(value = "/pubaccout", method = RequestMethod.GET)
    public String getWechatPubAccout()
    {
        return "pubaccout";
    }




}
