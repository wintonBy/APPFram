package com.af.appfram.aspectj;

import android.text.TextUtils;

import com.af.appfram.aspectj.annotation.DataCollect;
import com.af.appfram.utils.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author: winton
 * @time: 2018/1/11 17:00
 * @package: com.af.appfram.aspectj
 * @project: APPFram
 * @mail:
 * @describe: 日志采集的切面处理类
 */
@Aspect
public class DataCollectAspect {

    @Pointcut("execution(@com.af.appfram.aspectj.annotation.DataCollect * *(..))")
    public void dataCollect(){

    }

    @Before("dataCollect()")
    public void dealDataCollect(JoinPoint point) throws Throwable{
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataCollect dataCollect = signature.getMethod().getAnnotation(DataCollect.class);
        String pointName = dataCollect.pointName();
        LogUtils.d("测试dataCollect");
        if(TextUtils.isEmpty(pointName)){
            return;
        }
        LogUtils.d(pointName);
    }

}
