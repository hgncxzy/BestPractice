package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.broadcastbestpractice.base.BaseActivity;

/**
 * 《第一行代码》 第五章，广播的最佳实践 -- 强制下线
 */
public final class LoginActivity extends BaseActivity {

    private EditText etAccount, etPass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
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
}