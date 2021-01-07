package com.zbk.lib_network.api;

import android.util.Log;

import com.zbk.lib_network.config.Configurator;
import com.zbk.lib_network.interceptor.AddHeadersInterceptor;
import com.zbk.lib_network.interceptor.HttpLoggingInterceptor;
import com.zbk.lib_network.interceptor.MoreBaseUrlInterceptor;
import com.zbk.lib_network.util.LogUtil;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ZBK on 2020-12-20.
 *
 * @function
 */
public class RetrofitCreateHelper {
    private static final int TIMEOUT_READ = 60;
    private static final int TIMEOUT_CONNECTION = 60;

    private static RetrofitCreateHelper instance;

    private Retrofit mRetrofit = null;
    public static RetrofitCreateHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitCreateHelper.class) {
                instance = new RetrofitCreateHelper();
            }
        }
        return instance;
    }

    private RetrofitCreateHelper() {
    }


    public Retrofit create(String baseURL) {
        return initRetrofit(baseURL, initOkHttp());
    }

    public Retrofit getRetrofit() {
        if(mRetrofit==null){
            Log.e("RetrofitCreateHelper","需要初始化RetrofitCreateHelper");
        }
        return mRetrofit;
    }

    /**
     * 初始化Retrofit
     */
    @NonNull
    private Retrofit initRetrofit(String baseURL, OkHttpClient client) {
        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  mRetrofit;
    }


    /**
     * 初始化okhttp
     */
    @NonNull
    private OkHttpClient initOkHttp() {
        return new OkHttpClient().newBuilder()
                .readTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)//设置写入超时时间
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                //失败重连
                .retryOnConnectionFailure(true)
                //处理多BaseUrl,添加应用拦截器
                .addInterceptor(new MoreBaseUrlInterceptor())
                //添加头部信息
                .addInterceptor(new AddHeadersInterceptor())
                .addInterceptor(new HttpLoggingInterceptor("httpLog"))//添加打印拦截器
                .build();
    }


}

