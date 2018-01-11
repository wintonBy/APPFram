package com.af.appfram.constant;


import com.af.appfram.MyApplication;
import com.af.appfram.utils.LogUtils;

/**
 * Created by winton on 2017/6/26.
 */

public class DevelopConfig {

    public static final boolean IS_DEBUG = true;

    public static final int LOG_LEVEL = LogUtils.LEVEL.DEBUG;

    // SDCard根目录名称
    public static final String ROOT_DIR_NAME = "AppFram";

    public static final String LOG_DIR = "/Logs/";

    public static final String TAG_DEFAULT = MyApplication.INSTANCE.getPackageName();

}
