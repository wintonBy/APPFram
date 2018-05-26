package com.af.appfram.network;


import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by winton on 2017/6/25.
 */

public abstract class BaseSubscriber<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(Subscription s) {
        if(NetworkUtils.isAvailableByPing()){
            s.request(Integer.MAX_VALUE);
        }else {
            onNetDisConnect();
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        onFailure(t);
    }

    @Override
    public void onComplete() {

    }

    /**
     * 成功回调
     * @param t
     */
    public abstract void onSuccess(T t);

    /**
     * 失败回调
     * @param t
     */
    public abstract void onFailure(Throwable t);

    /**
     * 网络未连接回调
     */
    public void onNetDisConnect(){
        ToastUtils.showShort("无网络");
    }

}
