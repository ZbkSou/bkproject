package com.zbk.lib_network.api;

import android.util.Log;

import com.zbk.lib_network.bean.ApiResponse;
import com.zbk.lib_network.util.RxExceptionUtil;

import java.util.Objects;

import androidx.annotation.NonNull;

import androidx.lifecycle.LifecycleObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZBK on 2020-12-20.
 *
 * @function
 */
public class NetHelperObserver <T extends ApiResponse> implements Observer<T>{

    private NetCallback<T> mCallback;

    public NetHelperObserver(NetCallback<T> callback) {
        mCallback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        if (mCallback != null) {
            if (t.isSuccess()) {
                mCallback.onSuccess(t);
            } else {
                mCallback.onFail(t.getErrorMsg());
            }
        }
    }

    @Override
    public void onError(@NonNull Throwable t) {
        Log.e("请求错误", Objects.requireNonNull(t.getMessage()));
        if (mCallback != null) {
            mCallback.onFail(RxExceptionUtil.exceptionHandler(t));
        }
    }

    @Override
    public void onComplete() {

    }

}