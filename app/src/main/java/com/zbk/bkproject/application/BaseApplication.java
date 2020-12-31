package com.zbk.bkproject.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zbk.lib_network.BuildConfig;
import com.zbk.lib_network.api.RetrofitCreateHelper;

public class BaseApplication extends Application {

    private static BaseApplication mApplication = null;

    @Override public void onCreate() {
        super.onCreate();
        mApplication = this;
        //设置retrofit
        String apiDomain = "https://api.caiyunapp.com";
        RetrofitCreateHelper.getInstance().create(apiDomain);

        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        //ARouter初始化
        ARouter.init(this);
    }

    public static BaseApplication getInstance() {
        return mApplication;
    }
}
