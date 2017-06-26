package com.af.appfram.network;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by winton on 2017/6/22.
 */

public interface ServerApi {

    public static final String BASE_URL = "https://pay.wasu.com/";

    @GET("{url}")
    Observable<ResponseBody> executeGet(@Path("url") String url, @QueryMap Map<String,String> params);

    @POST("{url}")
    Observable<ResponseBody> executePost(@Path("url")String url ,@QueryMap Map<String,String> params);
}
