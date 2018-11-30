package com.helloworld.erlangga.helloworld;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("everything")

    Call<ResponseModel>
    getLatestNews(@Query("q") String q, @Query("sortBy") String sort, @Query("apiKey") String apikey);
}
