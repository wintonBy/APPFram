package com.af.appfram.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: winton
 * @time: 2018/1/11 11:02
 * @package: com.af.appfram.aspectj
 * @project: APPFram
 * @mail:
 * @describe: 处理性能调试的类
 */
@Aspect
public class DebugAspect {

    @Pointcut("execution(@com.af.appfram.aspectj.annotation.DebugTrace * *(..))")
    public void executeDebugTrace(){

    }

    @Around("executeDebugTrace()")
    public Object dealPoint(ProceedingJoinPoint point) throws Throwable{
        long startTime = System.currentTimeMillis();
        final  String methodName = point.getSignature().getName();
        Object o = point.proceed();
        long endTime = System.currentTimeMillis();
        LogUtils.d(methodName+"耗时："+(endTime-startTime)+"ms");
        return o;
    }
}
