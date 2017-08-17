package com.af.appfram.utils;

import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

import com.af.appfram.MyApplication;


/**
 * Created by winton on 2017/6/26.
 */

public class ToastUtils {

    public static void showToast(String text){
        if(TextUtils.isEmpty(text)){
            return;
        }
        Toast.makeText(MyApplication.INSTANCE,text,Toast.LENGTH_SHORT).show();
    }

    public static void showToast(@StringRes int textId){
        Toast.makeText(MyApplication.INSTANCE,textId,Toast.LENGTH_SHORT).show();
    }

    public static void showLoading(){

    }
    public static void hideLoading(){

    }
}
