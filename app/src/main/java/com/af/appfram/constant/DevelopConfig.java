package com.af.appfram.constant;


import com.af.appfram.MyApplication;

/**
 * Created by winton on 2017/6/26.
 */

public class DevelopConfig {

    public static final boolean IS_DEBUG = true;

    public static final int LOG_LEVEL = LogUtils.LEVEL.DEBUG;

    public static final String TAG_DEFAULT = MyApplication.INSTANCE.getPackageName();

}
