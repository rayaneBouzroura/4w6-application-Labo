package com.example.complexe.http;

import com.example.complexe.Transfer.objtransferer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {
    @GET("exos/truc/complexe")
    Call<objtransferer> getObj(@Query("name") String nomObj);
}
