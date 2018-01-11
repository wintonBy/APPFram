package com.af.appfram.presenter;

import android.app.Application;

import com.af.appfram.MyApplication;
import com.af.appfram.contract.TestContract;
import com.af.appfram.network.BaseSubscriber;
import com.af.appfram.network.RetrofitClient;
import com.af.appfram.network.response.CategoryResponse;
import com.af.appfram.ui.activity.TestActivity;

import java.util.HashMap;

import okhttp3.ResponseBody;

/**
 * Created by winton on 2017/6/25.
 */

public class TestPresenter extends BasePresenter<TestActivity> {

    private TestContract.View mView;

    public TestPresenter(TestContract.View view){
        mView = view;
    }

    public void testGet(){

        RetrofitClient.getInstance(MyApplication.INSTANCE).getCategory("android",10,1,new BaseSubscriber<CategoryResponse>(){
            @Override
            public void onNext(CategoryResponse categoryResponse) {
                super.onNext(categoryResponse);
            }
        });
    }

}
