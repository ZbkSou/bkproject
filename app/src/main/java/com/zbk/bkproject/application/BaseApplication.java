package com.zbk.bkproject.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zbk.lib_network.api.RetrofitCreateHelper;

public class BaseApplication extends Application {

    private static BaseApplication mApplication = null;

    @Override public void onCreate() {
        super.onCreate();
        mApplication = this;
        //设置retrofit
        String apiDomain = "https://api.caiyunapp.com";
        RetrofitCreateHelper.getInstance().create(apiDomain);


        //ARouter初始化
        ARouter.init(this);
    }

    public static BaseApplication getInstance() {
        return mApplication;
    }
}
