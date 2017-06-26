package com.af.appfram.mvp;

/**
 * Created by winton on 2017/6/21.
 */

public interface IPresenter <V extends IView> {

    /**
     * @param view 绑定
     */
    void attachView(V view);
    /**
     * 防止内存的泄漏,清楚presenter与activity之间的绑定
     */
    void detachView();

    IView getView();
}
