package com.bk.ft_weather;

import com.bk.lib_base.basemvp.IBaseView;

/**
 * Created by ZBK on 2021-01-06.
 *
 * @function
 */
public interface HomeContract {

    interface HomePrestener{

        void getData();
    }

    interface HomeView extends IBaseView {
        void setView(String data);
    }
}
