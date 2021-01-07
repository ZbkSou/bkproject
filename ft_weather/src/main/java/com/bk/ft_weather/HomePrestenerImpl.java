package com.bk.ft_weather;

import com.bk.ft_weather.bean.RealtimeWeather;
import com.bk.lib_base.basemvp.BasePresenter;
import com.bk.lib_base.util.LogUtil;
import com.zbk.lib_network.api.NetCallback;
import com.zbk.lib_network.api.NetHelperObserver;
import com.zbk.lib_network.bean.ApiResponse;


/**
 * Created by ZBK on 2021-01-06.
 *
 * @function
 */
public class HomePrestenerImpl extends BasePresenter<HomeContract.HomeView> implements HomeContract.HomePrestener {

    private HomeModule module;

    public HomePrestenerImpl(HomeContract.HomeView view){
        attachView(view);
        module = new HomeModule();
    }



    @Override
    public void getData() {
        module.getDate("11,23",new NetHelperObserver<ApiResponse<RealtimeWeather>>(new NetCallback() {

            @Override
            public void onSuccess(ApiResponse response) {
                LogUtil.getInstance().d(response.toString());

            }

            @Override
            public void onFail(String msg) {
                LogUtil.getInstance().d(msg);
            }
        }));

    }
}
