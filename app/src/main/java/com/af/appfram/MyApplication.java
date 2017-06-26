package com.af.appfram;

import android.app.Application;

/**
 * Created by winton on 2017/6/25.
 */

public class MyApplication extends Application {

    public static MyApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
