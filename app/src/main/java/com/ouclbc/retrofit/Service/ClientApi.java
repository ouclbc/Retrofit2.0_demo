package com.ouclbc.retrofit.Service;

import com.ouclbc.retrofit.Module.News;
import com.ouclbc.retrofit.Module.StartImage;
import com.ouclbc.retrofit.Module.TodayNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by libaocheng on 2016/3/28.
 */
public interface ClientApi {

    /**
     * FIELD
     */

    String FIELD_NEWS_ID = "newsId";


    /**
     * URL
     */

    //获取启动页面图片
    String URL_GET_START_IMAGE = "start-image/1080*1776";

    //获取最新日报新闻列表
    String URL_GET_LATEST_NEWS = "news/latest";

    //获取新闻
    String URL_GET_NEWS = "news/{newsId}";


    /**
     * 获取今日日报新闻列表
     *
     * @return TodayNews
     */
    @GET(URL_GET_LATEST_NEWS)
    Call<TodayNews> getTodayNews();

    /**
     * 获取启动图片
     *
     * @return StartImage
     */
    @GET(URL_GET_START_IMAGE)
    Call<StartImage> getStartImage();

    /**
     * 获取新闻
     *
     * @param newsId long
     * @return News
     */
    @GET(URL_GET_NEWS)
    Call<News> getNews(@Path(FIELD_NEWS_ID) long newsId);
}
