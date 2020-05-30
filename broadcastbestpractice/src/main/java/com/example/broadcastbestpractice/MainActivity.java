package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.broadcastbestpractice.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_force_offline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //动态注册广播--需要创建一个广播接收器来接收该广播
                Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
