package com.example.listes.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceLong {

    @GET("exos/long/list")
    Call<List<Long>> getObj();

}
