package com.bk.lib_base.basemvp;

import org.jetbrains.annotations.NotNull;

import java.lang.ref.WeakReference;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by ZBK on 2021-01-06.
 *
 * @function
 */
public class BasePresenter<T extends IBaseView> implements LifecycleObserver {

    protected WeakReference<T> IView;

    /**
     * 绑定View
     * @param view
     */
    public void attachView(T view) {
        IView = new WeakReference<>(view);
    }


    /**
     * 解绑view
     * @param
     */
    public void detachView() {
        if (IView != null) {
            IView.clear();
            IView = null;
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        detachView();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(){

    }

}
