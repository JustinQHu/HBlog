package com.huqijun.blog.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by huqjiun on 11/22/2017.
 * 以Java 代码方式配置DispatchServlet
 */
public class WebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * DispatchServlet 作为前端控制器拦截处理所有请求，  分发到不同的Controller
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"};
    }
}
