package com.bk.lib_base.module;

import android.content.Context;

import com.bk.lib_base.bean.RealtimeWeather;
import com.zbk.lib_network.api.RetrofitCreateHelper;

import io.reactivex.Observable;

public class DataManager {
    private BizService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService = RetrofitCreateHelper.getInstance().create(context,BizService.class);
    }

}
