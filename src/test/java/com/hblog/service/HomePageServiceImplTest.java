package com.hblog.service;

import com.hblog.article.ArticleDetail;
import com.hblog.article.ArticleDescription;
import com.hblog.conf.RootConfig;
import javafx.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by huqijun on 11/23/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class HomePageServiceImplTest {


    @Autowired
    private HomePageServiceImpl homePageService;

    private final String  testContent = "title: 人为什么活着--迷茫与思考\n" +
            "date: 2016-03-25 22:52:45\n" +
            "categories: 随笔\n" +
            "tags: LifeThinking\n" +
            "\n" +
            "---\n" +
            "\n" +
            "## 迷茫\n" +
            "最近会有一些间隔性(几个月一次）的迷茫，迷茫人生到底应该怎么样子度过，常常是一整天的工作（经常态)或者是一整天游戏之后会觉得自己目前在做的事情一点意义也没有。 据说人贤者时间也容易思考类似的问题，不过还没有经历过。 这个时候总是很容易从更大的时间维度或者更大的空间维度审视自己的生活。 在时间层面看（假设我是未来的人，看今天的历史）历史没有我什么事情，在空间的层面看（把视角扩展到地球，太阳系，银河系，整个宇宙）也没有我什么事情，然后得出我和大部分人的人生并没有什么意义，对生活失去乐趣，觉得所有事情都无所谓了。\n" +
            "\n" +
            "\n" +
            "然后就会纠结一个问题，人活着到底是为了什么？\n" +
            "\n" +
            "\n" +
            "这个问题自大学以来就困扰着我。一般情况下我会忘了它，但总有那些个时刻它会来找我。\n" +
            "\n" +
            "\n" +
            "## 思考\n" +
            "\n" +
            "这个问题几千年来的成年人都遇到过，但从古至今都没有什么明确答案。\n" +
            "\n" +
            "\n" +
            "上一次它来找我时， 我给自己设定了个答案：世界上有那边多东西，风景，各种稀奇古怪的东西我没见过， 我要去看一看这些东西。 但是给自己设定这个答案的同时，又会想即使“世界那么大，我都看了看”又有什么意思呢？\n" +
            "\n" +
            "它时不时的找我也改变了我对工作的态度。 以前会觉得追求世俗意义上的事业成功，什么都可以忍受， 正如我司的那句名言一样：\n" +
            ">要么忍，要么狠，要么滚！\n" +
            "\n" +
            "后来又慢慢觉得追求世俗意义上的事业是可以的，但同时工作的开心也应该放在同等重要的位置上。\n" +
            "\n" +
            "平时同事家人都在耳边不停的说，要赶紧找女朋友，年龄到了。现在觉得顺其自然遇到三观相合，和拍的人就好， 遇不到单身也挺好，单身一辈子也挺好。\n" +
            "\n" +
            "\n" +
            "\n" +
            "## 几个幽灵\n" +
            "\n" +
            "有几个问题像幽灵一样会和我纠缠一生：\n" +
            "\n" +
            "1. 世界从何而来？\n" +
            "2. 我是谁？\n" +
            "3. 人活着是为了什么？\n" +
            "\n" +
            "这篇文章应该会是一篇持续性的文章，把自己和这几个幽灵持续纠缠的过程记录下，希望以后我会找到自己认可的答案！\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "***\n" +
            "*update in 2016/06/28 *    \n" +
            "认识心仪的姑娘，姑娘还单身，\n" +
            "我说，你很吸引我，第一天想谈甚欢；  \n" +
            "第二天姑娘说，我和你不可能了，中午有人向我表白， 我和他更合适；  \n" +
            "为什么他更合适，为什么不留几个月时间再考虑下？   \n" +
            "因为我和他认识比你早；\n" +
            "\n" +
            "这是我25年生命中经历过最戏剧，最命运的事情！ \n" +
            "\n" +
            "**资源有限，竞争无处不在，所以要主动，去尝试，去行动**   \n" +
            "**人生无常，所有要把握现在，要学习，要有成长**\n" +
            "\n";

    @Test
    public void testAiticleProcess()
    {

        Pair<ArticleDescription,ArticleDetail> ret = homePageService.articleProcess(testContent);

        System.out.println(ret.getKey().getArticleName());
        System.out.println(ret.getKey().getTag());
        System.out.println(ret.getKey().getPublishDate());
        System.out.println(ret.getKey().getDigest());
        System.out.println(ret.getKey().getComments());
        System.out.println(ret.getKey().getReadCount());

        System.out.println("---------------------------------------------------------");

        System.out.println(ret.getValue().getArticleName());
        System.out.println(ret.getValue().getMarkdownContent());
        System.out.println(ret.getValue().getHtmlContent());

    }


    @Test
    public void getArticleName() throws Exception {
        System.out.println( homePageService.getArticleName("VPN" ) );
        System.out.println( homePageService.getArticleName("YoutubeEnglishLearning" ) );
    }

    @Test
    public void getDetail() throws Exception {
        System.out.println( homePageService.getDetail( homePageService.getArticleName("VPN" ) ));
    }

    @Test
    public void getArticleList() throws Exception {
        List<ArticleDescription> articles = homePageService.getArticleList();

        for(ArticleDescription ar :  articles)
        {
            System.out.println(ar.getArticleName() + " " +  ar.getPublishDate() + " " + ar.getTag());
        }

    }




}