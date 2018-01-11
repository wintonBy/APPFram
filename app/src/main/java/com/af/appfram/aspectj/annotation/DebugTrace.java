package com.af.appfram.aspectj.annotation;

import org.aspectj.lang.annotation.Aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: winton
 * @time: 2018/1/11 10:14
 * @package: com.af.appfram.aspectj
 * @project: APPFram
 * @mail:
 * @describe: 自定义的性能调试工具注解
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD})
public @interface DebugTrace {
}
