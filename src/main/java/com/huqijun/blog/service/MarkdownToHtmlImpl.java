package com.huqijun.blog.service;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.util.Arrays;

/**
 * Created by huqijun on 11/22/2017.
 */
public class MarkdownToHtmlImpl implements MakrdownToHtmlService {

    private static MarkdownToHtmlImpl instance = new MarkdownToHtmlImpl();

    private MutableDataSet options;

    private MarkdownToHtmlImpl() {
        super();
        options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        // enable table parse!
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
    }

    //single mode
    public static MarkdownToHtmlImpl getInstance()
    {
        if(instance == null) {
            instance = new MarkdownToHtmlImpl();
        }
        return instance;
    }


    public String markdownToHtml(String markContent) {
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(markContent);
        //System.out.println(document.toString());
        String html = renderer.render(document);

        return html;
    }
}
