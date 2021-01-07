package com.bk.ft_weather;

import com.bk.lib_base.basemvp.BasePresenter;

/**
 * Created by ZBK on 2021-01-06.
 *
 * @function
 */
public class HomePrestenerImpl extends BasePresenter<HomeContract.HomeView> implements HomeContract.HomePrestener {


    public HomePrestenerImpl(HomeContract.HomeView view){
        attachView(view);
    }



    @Override
    public void getData() {

    }
}
