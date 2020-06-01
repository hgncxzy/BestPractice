package com.example.broadcastbestpractice.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

import com.example.broadcastbestpractice.LoginActivity;
import com.example.broadcastbestpractice.controller.ActivityController;

import java.util.Objects;

/**
 * @author xzy
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline.Please try to login again.");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                //销毁所有的活动
                ActivityController.finishAll();
                Intent intent = new Intent(context, LoginActivity.class);
                //在广播接收器里面启动活动，因此一定要给intent加入如下标识。
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        //需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        // Android 8.0 以及以后的系统需要这样设置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 前提要动态申请相关权限（android.settings.action.MANAGE_OVERLAY_PERMISSION），不然依然会闪退
            Objects.requireNonNull(alertDialog.getWindow())
                    .setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
        } else {
            Objects.requireNonNull(alertDialog.getWindow())
                    .setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        }
        alertDialog.show();
    }
}