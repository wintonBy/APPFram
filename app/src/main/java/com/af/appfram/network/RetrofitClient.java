package com.af.appfram.network;

import android.content.Context;
import android.text.TextUtils;

import com.af.appfram.network.response.CategoryResponse;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by winton on 2017/6/23.
 */

public class RetrofitClient {

    private static Context mContext;
    private static final int DEFAULT_TIMEOUT = 5;
    private ServerApi mServer;

    public static String baseUrl = ServerApi.BASE_URL;


    private OkHttpClient mOkHttpClient;


    private static class InstanceHolder{
        private static RetrofitClient instance = new RetrofitClient(mContext);
    }

    public static RetrofitClient getInstance(Context context){
        if(context != null){
            mContext = context;
        }
        return InstanceHolder.instance;
    }


    private RetrofitClient(Context context){
        this(context,null);
    }

    private RetrofitClient(Context context,String url){
        if(TextUtils.isEmpty(url)){
            url = baseUrl;
        }
        mOkHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                        .build();
        Retrofit retrofit = new Retrofit.Builder()
                                .client(mOkHttpClient)
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                .baseUrl(url)
                                .build();
        mServer = retrofit.create(ServerApi.class);
    }

    /**
     * 线程调度器
     * @return
     */
    Observable.Transformer schedulersTransForm(){
        return new Observable.Transformer() {
            @Override
            public Object call(Object observable) {
                return ((Observable)observable).subscribeOn(Schedulers.io())
                                                .unsubscribeOn(Schedulers.io())
                                                .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /****************************************接口实现*********************************************/

    public void post(String url , Map<String,String> params, Subscriber<ResponseBody> subscriber){
        mServer.executePost(url,params)
                .compose(schedulersTransForm())
                .subscribe(subscriber);
    }

    public void get(String url,Map<String,String> params,Subscriber<ResponseBody> subscriber){
        mServer.executeGet(url,params)
                .compose(schedulersTransForm())
                .subscribe(subscriber);
    }

    public void getCategory(String category, int count , int page, Subscriber<CategoryResponse> subscriber){
        mServer.getCategory(category,count,page)
                .compose(schedulersTransForm())
                .subscribe(subscriber);
    }

}
