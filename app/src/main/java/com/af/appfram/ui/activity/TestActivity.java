package com.af.appfram.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.af.appfram.R;
import com.af.appfram.aspectj.annotation.DataCollect;
import com.af.appfram.contract.TestContract;
import com.af.appfram.presenter.TestPresenter;

/**
 * Created by winton on 2017/6/25.
 */

public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View{

    @DataCollect(pointName = "initView")
    @Override
    protected void initView() {
        setContentView(R.layout.act_test);
    }


    public void doGet(View view){
        mPresenter.testGet();
    }

    @DataCollect(pointName = "doPost")
    public void doPost(View view){

    }

    @Override
    public void showResult(String text) {
        if(TextUtils.isEmpty(text)){
            text = "等待结果...";
        }
        ((TextView)findViewById(R.id.tv_result)).setText(text);
    }

    @Override
    protected TestPresenter loadPresenter() {
        return new TestPresenter(this);
    }
}
