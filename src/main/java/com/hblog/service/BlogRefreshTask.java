package com.hblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

/**
 * Created by huqijun on 12/25/2017.
 * Task to refresh article list and article detail content period.
 */
@Component
public class BlogRefreshTask extends TimerTask{

    //delay and interval of refresh task
    public static long delay =  600000;    // 10 minute
    public static long interval = 600000;   // 10 minute


    /**
     *  object managed by Spring IOC,  single instance object in whole scope.
     */
    @Autowired
    private PageService pageService;


    @Override
    public void run() {
        pageService.refreshCache();
    }
}
