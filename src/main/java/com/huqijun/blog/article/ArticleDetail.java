package com.huqijun.blog.article;

import com.huqijun.blog.service.MarkdownToHtmlImpl;

import java.time.LocalDate;

/**
 * Created by huqijun on 11/22/2017.
 * detail of an article
 */
public class ArticleDetail {

    //article name
    private String articleName;

    //markdown content of article
    private String markdownContent;

    //html content of article
    private String htmlContent;

    /**
     * constructor
     * @param articleName
     * @param markdownContent
     */
    public ArticleDetail(String articleName, String markdownContent) {
        this.articleName = articleName;
        this.markdownContent = markdownContent;
        this.htmlContent = MarkdownToHtmlImpl.getInstance().markdownToHtml(this.markdownContent);
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getMarkdownContent() {
        return markdownContent;
    }

    public void setMarkdownContent(String markdownContent) {
        this.markdownContent = markdownContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
}
