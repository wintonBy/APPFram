package com.af.appfram.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Primitives;

import java.lang.reflect.Type;

/**
 * Created by winton on 2017/7/16.
 */

public class StringUtils {

    /**
     * 处理异常的Gson
     * @param data
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T>T safeGsonFrom(String data,Class<T> classOfT ){
        if(TextUtils.isEmpty(data)){
            return null;
        }
        Gson gson = new Gson();
        try {
            Object object = gson.fromJson(data, (Type) classOfT);
            return Primitives.wrap(classOfT).cast(object);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            LogUtils.e("StirngUtil",e.getMessage());
        }
        return null;
    }

    /**
     * 判断是否为邮箱
     * @param str
     * @return
     */
    public static boolean isEmail(String str){
        if(TextUtils.isEmpty(str)){
            return false;
        }
        final  String REGX = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        if(str.matches(REGX)){
            return true;
        }
        return false;
    }

    /**
     * 判断内容是否为手机号
     * @param str
     * @return
     */
    public static boolean isPhone(String str){
        if(TextUtils.isEmpty(str)){
            return false;
        }
        if(TextUtils.isDigitsOnly(str)&& str.length() == 11){
            return true;
        }
        return false;
    }

}
