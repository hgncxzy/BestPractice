package com.xzy.view.fragmentpractice;

import android.os.Bundle;
import android.view.Window;
import android.app.Activity;

/**
 * 《第一行代码》第四章 fragment 最佳实践
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
}
