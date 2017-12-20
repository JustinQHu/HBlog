package com.huqijun.blog.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huqijun on 11/23/2017.
 * tool to do reg match...
 */
public class RegUtil {

    public static final String markdwonFormatReg = "%s:(?<%s>.+)\\n";


    /**
     * find values of given property using regular match in gigen content
     * @param property
     * @param content
     * @return
     */
    public static String foundArticleProperties(String property, String content)
    {
        String reg = String.format(markdwonFormatReg, property, property);
        Matcher match = Pattern.compile(reg).matcher(content);
        if(match.find())
        {
            return match.group(property);
        }
        else
        {
            return null;
        }
    }
}
