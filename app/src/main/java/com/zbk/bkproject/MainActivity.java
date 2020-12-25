package com.zbk.bkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zbk.lib_network.util.LogUtil;

public class MainActivity extends AppCompatActivity {

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
            }
        });
    }
}
