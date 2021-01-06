package com.bk.ft_login;

import com.bk.lib_base.basemvp.IBaseView;

/**
 * Created by ZBK on 2021-01-06.
 *
 * @function
 */
public interface LoginContract {

    interface LoginePrestener{
        void setData(String data);
        void getData();
    }

    interface LoginView extends IBaseView {
        void setView(String data);
    }
}
