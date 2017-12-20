package com.huqijun.blog.util;

import com.huqijun.blog.conf.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Created by huqijun on 11/23/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class FileUtilTest {

    @Test
    public void readToStr() throws Exception {
        String content =  FileUtil.readToStr("src/main/resources/blog/时间管理，轻重缓急.md");
        System.out.println(content);


    }

    @Test
    public void readAll() throws Exception {

        List<String>  ls = FileUtil.readAll("src/main/resources/blog");
        System.out.println(ls.size());
        for(String s : ls)
        {
            System.out.println(s);
        }

    }


    @Test
    public void regMatch()
    {
        String org = "title: 时间管理，轻重缓急\n" +
                "date: 2016-06-26 10:12:37\n" +
                "categories: 自我管理\n" +
                "tags: 时间管理\n" +
                "\n" +
                "---\n" +
                "\n" +
                "### 概述 \n" +
                "时间管理是现代职场人士的必备技能。 现代人如何在快节奏的职场中做好工作？   如何平衡好工作和个人生活，家庭生活的关系？\n" +
                "\n" +
                "> 事分轻重缓急， 轻重指的是事情的重要性这一维度，  缓急指的是事情的迫切性这一个维度  \n" +
                "> 尽量多的做重要不紧急的事情，  这个是时间管理的核心";

        String regKeys[] = {"title", "date", "tags"};

        for(String key: regKeys)
        {
            String regex =    key + ":(?<" + key +">.+)\\n";
            Pattern r = Pattern.compile(regex);
            Matcher m = r.matcher(org);
            while (m.find())
                System.out.println(m.group(key));
        }

    }

}