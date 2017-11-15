package com.af.appfram.presenter;

import com.af.appfram.mvp.IPresenter;
import com.af.appfram.mvp.IView;

import java.lang.ref.WeakReference;

/**
 * Created by winton on 2017/6/25.
 */

public class BasePresenter<V extends IView> implements IPresenter {


    private WeakReference actReference;  //activity 弱引言
    protected  V iView;


    @Override
    public void attachView(IView view) {
        actReference = new WeakReference(view);
    }

    @Override
    public void detachView() {
        if(actReference != null){
            actReference.clear();
            actReference = null;
        }
    }

    @Override
    public IView getView() {
        return (V)actReference.get();
    }

}
