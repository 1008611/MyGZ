package com.wildwolf.mygz.model.http;

import com.wildwolf.mygz.model.WelcomeBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/12/13.
 */
public interface ZhihuApis {
    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 启动界面图片
     */
    @GET("start-image/{res}")
    Observable<WelcomeBean> getWelcomeInfo(@Path("res") String res);

}
