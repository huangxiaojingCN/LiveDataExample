package com.honey.livedataexample;

import com.honey.livedataexample.model.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApiService {

    @FormUrlEncoded
    @POST(".")
    Call<Result> getFoodList(@Field("keyword") String keyword,
                             @Field("num") int num,
                             @Field("start") int start,
                             @Field("appkey") String appkey);
}
