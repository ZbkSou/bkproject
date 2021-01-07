package com.bk.ft_weather;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bk.lib_base.base.BaseActivity;
import com.bk.lib_base.basemvp.BasePresenter;
import com.bk.lib_base.common.Constance;
import com.zbk.lib_network.util.LogUtil;

@Route(path = Constance.ACTIVITY_URL_HOME)
public class HomeActivity extends BaseActivity implements HomeContract.HomeView {

    private TextView textView;
    private HomeContract.HomePrestener  prestener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView = findViewById(R.id.tv_hw);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogUtil.show("tx click");

            }
        });
        prestener = new HomePrestenerImpl(this);
        prestener.getData();
    }

    @Override
    public void setView(String data) {

    }

    @Override
    public void showErrorMessage(String msg) {

    }
}