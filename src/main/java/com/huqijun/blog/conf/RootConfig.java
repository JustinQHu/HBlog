package com.huqijun.blog.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huqijun on 11/22/2017.
 */
@Configuration
@ComponentScan(basePackages = {"com.huqijun.blog.article",  "com.huqijun.blog.service", "com.huqijun.blog.util"})
public class RootConfig {
}
