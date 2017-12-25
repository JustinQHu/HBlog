package com.hblog.service;

/**
 * Created by huqijun on 11/22/2017
 */
public interface MakrdownToHtmlService {

    /**
     * convert markdown to html.
     * @param markContent
     * @return
     */
    String markdownToHtml(String markContent);
}
