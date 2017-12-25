package com.hblog.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Timer;

/**
 * Created by huqijun on 12/25/2017.
 */
@Component
public class TaskExecutor  implements InitializingBean{


    @Autowired
    private BlogRefreshTask blogRefreshTask;

    @Override
    public void afterPropertiesSet() throws Exception {
        new Timer().schedule(blogRefreshTask, BlogRefreshTask.delay, BlogRefreshTask.interval);
    }
}
