package com.zbk.lib_network.api;

import com.zbk.lib_network.bean.ApiResponse;

/**
 * Created by ZBK on 2020-12-20.
 *
 * @function
 */
public interface NetCallback<T extends ApiResponse> {

    void onSuccess(T response);

    void onFail(String msg);
}