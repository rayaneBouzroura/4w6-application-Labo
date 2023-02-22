package com.example.repos.http;


import com.example.repos.transfer.repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("users/jorisdeguet/repos")
    Call<List<repo>> getRepo();



}
