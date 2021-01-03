package com.zbk.bkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bk.lib_base.base.BaseActivity;
import com.bk.lib_base.common.Constance;
import com.zbk.lib_network.util.LogUtil;

@Route(path = Constance.ACTIVITY_URL_MAIN)
public class MainActivity extends BaseActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_hw);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogUtil.show("tx click");
                ARouter.getInstance().build(Constance.ACTIVITY_URL_LOGIN).navigation();
            }
        });
    }
}
