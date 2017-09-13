package com.af.appfram.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.af.appfram.MyApplication;

/**
 * Created by winton on 2017/6/26.
 */

public class NetworkUtils {

    public enum NetType {
        None(1),
        Mobile(2),
        Wifi(4),
        Other(8);

        NetType(int value) {
            this.value = value;
        }

        public int value;
    }

    public enum NetWorkType {
        UnKnown(-1),
        Wifi(1),
        Net2G(2),
        Net3G(3),
        Net4G(4);

        NetWorkType(int value) {
            this.value = value;
        }

        public int value;
    }

    /**
     * 判断网络是否可用
     * @return
     */
    public static boolean hasNetwork(){
        boolean result = false;
        ConnectivityManager mCM =(ConnectivityManager) MyApplication.INSTANCE.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = mCM.getActiveNetworkInfo();
        if(networkInfo == null){
            return result;
        }
        if(networkInfo.isAvailable() && networkInfo.isAvailable()){
            result = true;
        }
        return result;
    }

    /**
     * 判断网络类型
     * @return
     */
    public static NetType getConnectType(){
        ConnectivityManager mCM =(ConnectivityManager) MyApplication.INSTANCE.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = mCM.getActiveNetworkInfo();
        if(networkInfo != null){
            switch (networkInfo.getType()){
                case ConnectivityManager.TYPE_WIFI:
                    return NetType.Wifi;
                case ConnectivityManager.TYPE_MOBILE:
                    return NetType.Mobile;
                default:
                    return NetType.Other;
            }
        }
        return NetType.None;
    }

}
