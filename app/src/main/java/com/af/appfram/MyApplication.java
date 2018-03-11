package com.af.appfram;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import com.af.appfram.aspectj.annotation.DebugTrace;
import com.af.appfram.constant.DevelopConfig;
import com.af.appfram.crash.CrashHandler;
import com.af.appfram.utils.LogUtils;
import com.af.appfram.utils.SDcardUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winton on 2017/6/25.
 */

public class MyApplication extends Application {

    public static MyApplication INSTANCE;

    private List<WeakReference<Activity>> mActivitys;

    @DebugTrace
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initUtils();

    }

    /**
     * 初始化工具类
     */
    @DebugTrace
    private void initUtils(){
        /*初始化SD卡工具类*/
        SDcardUtil.initDir("");
        /*初始化日志工具类*/
        LogUtils.init(DevelopConfig.LOG_LEVEL,DevelopConfig.LOG_LEVEL,SDcardUtil.getLogDir());
        /*全局异常捕获*/
        CrashHandler.getInstance().init();

    }

    public void addActivity(@NonNull WeakReference<Activity> activity){
        if(mActivitys == null){
            mActivitys = new ArrayList<>();
        }
        mActivitys.add(activity);
    }

    public void removeActivity(@NonNull WeakReference<Activity> activity){
        if(mActivitys == null){
            return;
        }
        if(mActivitys.contains(activity)){
            mActivitys.remove(activity);
        }
    }

    /**
     * 安全退出应用
     */
    public void exit(){
        if(mActivitys != null){
            for (WeakReference<Activity> activityWeakReference : mActivitys){
                activityWeakReference.get().finish();
            }
        }
    }

}
