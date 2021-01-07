package com.bk.lib_base.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bk.lib_base.basemvp.BasePresenter;

public  class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
    }

    public void setPresenter(BasePresenter presenter){
        if(presenter !=null){
            getLifecycle().addObserver(presenter);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
