package com.bk.lib_base.base;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bk.lib_base.base.constant.Constant;
import com.bk.lib_base.basemvp.BasePresenter;

public  class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().inject(this);
    }
    /**
     * 申请指定的权限.
     */
    public void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }
    public void setPresenter(BasePresenter presenter){
        if(presenter !=null){
            getLifecycle().addObserver(presenter);
        }
    }
    /**
     * 判断是否有指定的权限
     */
    public boolean hasPermission(String... permissions) {

        for (String permisson : permissions) {
            if (ContextCompat.checkSelfPermission(this, permisson) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case Constant.WRITE_READ_EXTERNAL_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    doSDCardPermission();
                }
                break;
            case Constant.HARDWEAR_CAMERA_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    doCameraPermission();
                }
                break;
        }
    }

    /**
     * 处理整个应用用中的SDCard业务
     */
    public void doSDCardPermission() {
    }

    public void doCameraPermission() {
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
