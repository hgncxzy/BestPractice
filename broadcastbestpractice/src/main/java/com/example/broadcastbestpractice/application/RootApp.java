package com.example.broadcastbestpractice.application;

import android.app.Application;

public class RootApp extends Application {
    public static RootApp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
