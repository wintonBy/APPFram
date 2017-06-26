package com.af.appfram.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.af.appfram.mvp.IView;
import com.af.appfram.presenter.BasePresenter;

/**
 * Created by winton on 2017/6/22.
 */

public abstract class BaseActivity<P extends BasePresenter> extends Activity implements IView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mPresenter = loadPresenter();
        initCommonData();
        initListener();
        initData();

    }
    protected abstract void initView();

    protected abstract P loadPresenter();

    /**
     * 初始化页面监听器，由子类重载
     */
    protected void initListener(){

    }

    /**
     * 初始化页面数据，由子类重载
     */
    protected void initData(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detachView();
        }
    }

    private void initCommonData(){
        if(mPresenter != null){
            mPresenter.attachView(this);
        }
    }
}
