package com.bk.ft_weather.api;

import com.zbk.lib_network.api.RetrofitCreateHelper;

public class ApiHelper {
    private BizService service;
    private static ApiHelper instance;

    public static ApiHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitCreateHelper.class) {
                instance = new ApiHelper();
            }
        }
        return instance;
    }

    public BizService getService() {
        return service;
    }

    private ApiHelper(){
        service = RetrofitCreateHelper.getInstance().getRetrofit().create(BizService.class);
    }
}
