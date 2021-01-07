package com.bk.ft_weather;

import com.bk.ft_weather.api.ApiHelper;
import com.bk.ft_weather.bean.RealtimeWeather;
import com.bk.lib_base.basemvp.BaseModel;
import com.zbk.lib_network.api.NetCallback;
import com.zbk.lib_network.api.NetHelperObserver;
import com.zbk.lib_network.bean.ApiResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeModule extends BaseModel {


    void getDate(String lonlat,NetHelperObserver observer){
        ApiHelper.getInstance().getService().getRealtimeWeather("Y2FpeXVuIGFuZHJpb2QgYXBp",lonlat)
                .subscribeOn(Schedulers.io())  // 网络请求切换在io线程中调用
                .unsubscribeOn(Schedulers.io())// 取消网络请求放在io线程
                .observeOn(AndroidSchedulers.mainThread())// 观察后放在主线程调用
                .subscribe(observer);
    }




}
