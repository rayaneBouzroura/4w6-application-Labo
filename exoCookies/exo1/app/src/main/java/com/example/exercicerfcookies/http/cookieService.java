package com.example.exercicerfcookies.http;

import retrofit2.Call;
import retrofit2.http.GET;

public interface cookieService {

    @GET("exos/cookie/echo")
    Call<String> cookieEcho();
}
