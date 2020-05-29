package com.xzy.activitybestpractice;

import android.os.Bundle;
import android.view.View;

import com.xzy.activitybestpractice.base.BaseActivity;
import com.xzy.activitybestpractice.controller.ActivityController;

/**
 * 第一行代码第二章， Activity 的最佳实践
 *
 * @author xzy
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.actionStart(MainActivity.this, "xzy", "hello world!");
            }
        });
        findViewById(R.id.btn_finish_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityController.finishAll();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }
}
