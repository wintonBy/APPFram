package com.af.appfram.aspectj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: winton
 * @time: 2018/1/11 16:58
 * @package: com.af.appfram.aspectj
 * @project: APPFram
 * @mail:
 * @describe: 用于日志采集的注解
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD})
public @interface DataCollect {
    String pointName();
}
