package com.af.appfram.presenter;

import com.af.appfram.MyApplication;
import com.af.appfram.contract.TestContract;
import com.af.appfram.network.BaseSubscriber;
import com.af.appfram.network.RetrofitClient;
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
        String url = "";
        RetrofitClient.getInstance(MyApplication.INSTANCE).get(url,new HashMap<String, String>(),new BaseSubscriber<ResponseBody>(){
            @Override
            public void onError(Throwable e) {
                super.onError(e);
               mView.showResult(e.getMessage());
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                super.onNext(responseBody);
                try {
                    mView.showResult(responseBody.string());
                }catch (Exception e){

                }

            }
        });
    }

}
