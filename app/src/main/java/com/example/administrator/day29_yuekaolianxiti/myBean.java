package com.example.administrator.day29_yuekaolianxiti;

import com.google.gson.Gson;

import java.util.List;

/**
 * date 2017/7/26
 * author:张学雷(Administrator)
 * functinn:
 */

public class myBean {


    /**
     * newslist : {"news":[{"title":"程序员因写代码太乱被杀害","detail":"凶手是死者同事，维护死者代码时完全看不懂而痛下杀手","comment":"16359","image":"http://huixinguiyu.cn/Assets/images/a1.png"},{"title":"产品经理因频繁改需求被杀害","detail":"凶手是一名程序员，因死者对项目需求频繁改动而痛下杀手","comment":"14112","image":"http://huixinguiyu.cn/Assets/images/a2.png"},{"title":"3Q大战宣判: 腾讯获赔500万","detail":"最高法驳回360上诉, 维持一审宣判.","comment":"6427","image":"http://huixinguiyu.cn/Assets/images/a3.png"},{"title":"今日之声:北大雕塑被戴口罩","detail":"市民: 因雾霾起诉环保局; 公务员谈\"紧日子\": 坚决不出去.","comment":"681","image":"http://huixinguiyu.cn/Assets/images/a4.png"},{"title":"奥巴马见达赖是装蒜","detail":"外文局: 国际民众认可中国大国地位;法院: \"流量清零\"未侵权.","comment":"1359","image":"http://huixinguiyu.cn/Assets/images/a5.png"},{"title":"轻松一刻: 我要沉迷学习不自拔","detail":"放假时我醒了不代表我起床了, 如今我起床了不代表我醒了!","comment":"11616","image":"http://huixinguiyu.cn/Assets/images/a6.png"},{"title":"今日之声:北大雕塑被戴口罩","detail":"市民: 因雾霾起诉环保局; 公务员谈\"紧日子\": 坚决不出去.","comment":"681","image":"http://huixinguiyu.cn/Assets/images/a7.png"},{"title":"奥巴马见达赖是装蒜","detail":"外文局: 国际民众认可中国大国地位;法院: \"流量清零\"未侵权.","comment":"1359","image":"http://huixinguiyu.cn/Assets/images/a7.png"}]}
     */

    public NewslistBean newslist;

    public static myBean objectFromData(String str) {

        return new Gson().fromJson(str, myBean.class);
    }

    public static class NewslistBean {
        public List<NewsBean> news;

        public static NewslistBean objectFromData(String str) {

            return new Gson().fromJson(str, NewslistBean.class);
        }

        public static class NewsBean {
            /**
             * title : 程序员因写代码太乱被杀害
             * detail : 凶手是死者同事，维护死者代码时完全看不懂而痛下杀手
             * comment : 16359
             * image : http://huixinguiyu.cn/Assets/images/a1.png
             */

            public String title;
            public String detail;
            public String comment;
            public String image;

            public static NewsBean objectFromData(String str) {

                return new Gson().fromJson(str, NewsBean.class);
            }
        }
    }
}
