package com.zbk.bkproject.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApplication extends Application {

    private static BaseApplication mApplication = null;

    @Override public void onCreate() {
        super.onCreate();
        mApplication = this;

        //ARouter初始化
        ARouter.init(this);
    }

    public static BaseApplication getInstance() {
        return mApplication;
    }
}
