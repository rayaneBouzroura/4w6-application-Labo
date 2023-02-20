package com.example.simple.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("exos/long/double/{chiffre}")
    Call<String> getDouble(@Path("chiffre") String chiffreDoubler);
}
