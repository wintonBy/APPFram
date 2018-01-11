package com.af.appfram.network;

import com.af.appfram.network.response.CategoryResponse;

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

    public static final String BASE_URL = "http://gank.io/api/";

    @GET("{url}")
    Observable<ResponseBody> executeGet(@Path("url") String url, @QueryMap Map<String,String> params);
    @POST("{url}")
    Observable<ResponseBody> executePost(@Path("url")String url ,@QueryMap Map<String,String> params);


    /*声明一个接口*/
    @GET("data/{category}/{count}/{page}")
    Observable<CategoryResponse> getCategory(@Path("category")String category, @Path("count")int count, @Path("page")int page);
}
