package com.example.listes.http;

import com.example.listes.transfert.objList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("exos/long/list")
    Call<List<Long>> getLongList();

    @GET("exos/truc/list")
    Call<List<objList>> getComplexeList();

}
