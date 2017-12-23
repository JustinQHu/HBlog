package com.hblog.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huqijun on 11/22/2017.
 */
@Configuration
@ComponentScan(basePackages = {"com.hblog.article",  "com.hblog.service", "com.hblog.util"})
public class RootConfig {
}
