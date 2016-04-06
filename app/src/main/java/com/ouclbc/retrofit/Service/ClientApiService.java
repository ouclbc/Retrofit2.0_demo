package com.ouclbc.retrofit.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by libaocheng on 2016/3/28.
 */
public class ClientApiService {
    private static final String API_VERSION = "4";
    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/";

    private static  Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static ClientApi getApi() {
        return retrofit.create(ClientApi.class);
    }
}
