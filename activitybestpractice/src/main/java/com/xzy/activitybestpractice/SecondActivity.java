package com.xzy.activitybestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.xzy.activitybestpractice.base.BaseActivity;

/**
 * @author xzy
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
    }

    /**
     * 最佳启动写法：我不需要知道 SecondActivity 中具体代码细节，也不用询问代码编写者，
     * 只需要看该方法的参数就明了，这样写简化了启动活动的代码
     *
     * @param context 上一个页面
     * @param data1   数据
     * @param data2   数据
     */
    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}