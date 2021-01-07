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


    void getDate(String lonlat){
        ApiHelper.getInstance().getService().getRealtimeWeather("86b442d914b3eb28e78cbfc96e6b72ea",lonlat)
                .subscribeOn(Schedulers.io())  // 网络请求切换在io线程中调用
                .unsubscribeOn(Schedulers.io())// 取消网络请求放在io线程
                .observeOn(AndroidSchedulers.mainThread())// 观察后放在主线程调用
                .subscribe(new NetHelperObserver<ApiResponse<RealtimeWeather>>(new NetCallback() {

                    @Override
                    public void onSuccess(ApiResponse response) {

                    }

                    @Override
                    public void onFail(String msg) {

                    }
                }));
    }




}
