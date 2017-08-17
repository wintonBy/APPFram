package com.af.appfram.utils;

import android.text.TextUtils;
import android.util.Log;

import com.af.appfram.constant.DevelopConfig;


/**
 * Created by winton on 2017/6/23.
 */

public class LogUtils {

    public static class LEVEL{
        public static final int VERBOSE = 1;
        public static final int DEBUG = 2;
        public static final int INFO = 3;
        public static final int WARM = 4;
        public static final int ERROR = 5;
        public static final int WTF = 6;
    }

    private static int LogLevel = DevelopConfig.LOG_LEVEL;

    private static void pLog(String tag,String msg,int level){
        if(level < LogLevel){
            return;
        }
        switch (level){
            case LEVEL.VERBOSE:
                Log.v(tag,msg);
                break;
            case LEVEL.DEBUG:
                Log.d(tag,msg);
                break;
            case LEVEL.INFO:
                Log.i(tag,msg);
                break;
            case LEVEL.WARM:
                Log.w(tag,msg);
                break;
            case LEVEL.ERROR:
                Log.e(tag,msg);
                break;
            case LEVEL.WTF:
                Log.wtf(tag,msg);
                break;
        }
    }
    private static void pLog(String tag,String msg,Throwable tr,int level){
        if(level < LogLevel){
            return;
        }
        switch (level){
            case LEVEL.VERBOSE:
                Log.v(tag,msg,tr);
                break;
            case LEVEL.DEBUG:
                Log.d(tag,msg,tr);
                break;
            case LEVEL.INFO:
                Log.i(tag,msg,tr);
                break;
            case LEVEL.WARM:
                Log.w(tag,msg,tr);
                break;
            case LEVEL.ERROR:
                Log.e(tag,msg,tr);
                break;
            case LEVEL.WTF:
                Log.wtf(tag,msg,tr);
                break;
        }
    }
    public static void v(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = DevelopConfig.TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.VERBOSE);
    }
    public static void d(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = DevelopConfig.TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.DEBUG);
    }
    public static void i(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = DevelopConfig.TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.INFO);
    }
    public static void w(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = DevelopConfig.TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.WARM);
    }
    public static void e(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = DevelopConfig.TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.ERROR);
    }
    public static void wtf(String tag,String msg){
        if(TextUtils.isEmpty(tag)){
            tag = DevelopConfig.TAG_DEFAULT;
        }
        pLog(tag,msg,LEVEL.WTF);
    }

    public static void v(String msg){
        v(null,msg);
    }
    public static void d(String msg){
        d(null,msg);
    }
    public static void i(String msg){
        i(null,msg);
    }
    public static void w(String msg){
        w(null,msg);
    }
    public static void e(String msg){
        e(null,msg);
    }
    public static void wtf(String msg){
        wtf(null,msg);
    }


}
