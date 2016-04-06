package com.ouclbc.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ouclbc.retrofit.Module.TodayNews;
import com.ouclbc.retrofit.Service.ClientApi;
import com.ouclbc.retrofit.Service.ClientApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * @author libaocheng
 * 从知乎日报获取的api，api接口见如下分析：
https://github.com/izzyleung/ZhihuDailyPurify/wiki/%E7%9F%A5%E4%B9%8E%E6%97%A5%E6%8A%A5-API-%E5%88%86%E6%9E%90
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a call instance for looking up Retrofit contributors.
        Call<TodayNews> call = ClientApiService.getApi().getTodayNews();
        call.enqueue(new Callback<TodayNews>(){
            @Override
            public void onResponse(Call<TodayNews> call, Response<TodayNews> response) {
                Log.d("lbc",response.body().getDate());
                Log.d("lbc",response.body().getStories().toString());
                for (TodayNews.Story story : response.body().getStories()) {
                    Log.d("lbc",story.getTitle() + " (" + story.getImageUrl() + ")");
                }
            }

            @Override
            public void onFailure(Call<TodayNews> call, Throwable t) {

            }
        });
    }
}
