package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.broadcastbestpractice.base.BaseActivity;
import com.example.broadcastbestpractice.controller.ActivityController;
import com.example.broadcastbestpractice.permission.FloatTool;

/**
 * 《第一行代码》 第五章，广播的最佳实践 -- 强制下线
 */
public final class LoginActivity extends BaseActivity {

    private EditText etAccount, etPass;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        FloatTool.RequestOverlayPermission(this);
        setContentView(R.layout.activity_login);
        etAccount = findViewById(R.id.accountEdit);
        etPass = findViewById(R.id.passwordEdit);
        Button btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String account = etAccount.getText().toString();
                String password = etPass.getText().toString();
                //模拟登陆
                if (account.equals("xu") && password.equals("123")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "login failure", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Activity执行结果
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FloatTool.onActivityResult(requestCode, resultCode, data, this);
    }

}